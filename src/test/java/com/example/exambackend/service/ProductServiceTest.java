package com.example.exambackend.service;

import com.example.exambackend.dto.ProductDto;
import com.example.exambackend.dto.ProductMapper;
import com.example.exambackend.model.Product;
import com.example.exambackend.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private  ProductRepository productRepository;
    @Mock
    private  ProductMapper productMapper;

    private ProductService productService;

    @BeforeEach
    void setUp() {
productService = new ProductService(productRepository, productMapper);
    }

    @Test
    void getAllProducts() {
        Mockito.when(productRepository.findAll()).thenReturn(List.of(
                new Product("mad", 10,20),
                new Product("meremad", 10,20),
                new Product("mad2", 10,20)
                ));

        List<ProductDto> reservations = productService.getAllProducts();

        assertEquals(3,reservations.size());
    }
}