package com.example.exambackend.repository;

import com.example.exambackend.dto.ProductDto;
import com.example.exambackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public Product findByName(String name);
}
