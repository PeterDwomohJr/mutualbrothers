package com.comcent.mutualbrothers.controller;

import com.comcent.mutualbrothers.dto.ProductDto;
import com.comcent.mutualbrothers.service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public Flux<ProductDto> getProducts() {

        return productService.getProducts();
    }


    @GetMapping({"/{id}"})
    public Mono<ProductDto> getProduct(@PathVariable String id) {

        return productService.getProduct(id);
    }


    @GetMapping("/count")
    public Mono<Long> getProductCount() {

        return productService.getProductCount();
    }

    @GetMapping("/range")
    public Flux<ProductDto> getProductsBetweenRange(@RequestParam double min, @RequestParam double max) {

        return productService.getProductsBetweenPriceRange(min, max);
    }



    @PostMapping
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDtoMono) {

        return productService.saveProduct(productDtoMono);
    }


    @PutMapping("/{id}")
    public Mono<ProductDto> updateProduct(@PathVariable String id, @RequestBody Mono<ProductDto> productDtoMono) {

        return productService.updateProduct(id, productDtoMono);
    }


    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {

        return productService.deleteProduct(id);
    }


    @DeleteMapping
    public Mono<Void> deleteAllProducts() {

        return productService.deleteAllProducts();
    }
}
