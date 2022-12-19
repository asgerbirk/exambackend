package com.example.exambackend.controller;

import com.example.exambackend.dto.ProductDto;
import com.example.exambackend.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll(){
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(productService.findProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@Valid @RequestBody ProductDto productDto){
        return ResponseEntity.ok().body(productService.saveProduct(productDto));
    }

}
