package com.comcent.mutualbrothers.service;

import com.comcent.mutualbrothers.dto.ProductDto;
import com.comcent.mutualbrothers.repository.ProductRepository;
import com.comcent.mutualbrothers.utils.AppUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Flux<ProductDto> getProducts() {

        return productRepository.findAll().map(AppUtils::entityToDto);
    }


    public Mono<ProductDto> getProduct(String id) {

        return productRepository.findById(id).map(AppUtils::entityToDto);
    }


    public Flux<ProductDto> getProductsBetweenPriceRange(double min, double max) {

        return productRepository.findAll().map(AppUtils::entityToDto)
        .filter(products -> products.getPrice() >= min && products.getPrice() <= max);
    }



    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono) {

        return productDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(productRepository::insert)
                .map(AppUtils::entityToDto);
    }


    public Mono<ProductDto> updateProduct(String id, Mono<ProductDto> productDtoMono) {

        return productRepository.findById(id)
                .flatMap(product -> productDtoMono.map(AppUtils::dtoToEntity))
                .doOnNext(productEntity -> productEntity.setId(id))
                .flatMap(productRepository::save)
                .map(AppUtils::entityToDto);
    }


    public Mono<Void> deleteProduct(String id) {

        return productRepository.deleteById(id);
    }
}
