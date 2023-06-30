package com.comcent.mutualbrothers.utils;

import com.comcent.mutualbrothers.dto.ProductDto;
import com.comcent.mutualbrothers.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AppUtils {


    public static ProductDto entityToDto(Product product) {

        ProductDto productDto = new ProductDto();

        BeanUtils.copyProperties(product, productDto);

        return productDto;
    }


    public static Product dtoToEntity(ProductDto productDto) {

        Product product = new Product();

        BeanUtils.copyProperties(productDto, product);

        return product;
    }
}
