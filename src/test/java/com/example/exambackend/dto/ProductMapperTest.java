package com.example.exambackend.dto;

import com.example.exambackend.model.Product;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    void productToDto() {
        Product product = new Product("john", 10,10);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);

        assertEquals(productDto.getName(), product.getName());
        assertEquals(productDto.getPrice(), product.getPrice());
    }

    @Test
    void dtoToProduct() {
        Product productDto = new Product("john", 10,10);
        Product product = modelMapper.map(productDto, Product.class);

        assertEquals(product.getName(), productDto.getName());
        assertEquals(product.getWeight(), productDto.getWeight());

    }
}