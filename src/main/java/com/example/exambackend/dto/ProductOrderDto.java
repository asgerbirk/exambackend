package com.example.exambackend.dto;

import com.example.exambackend.model.Delivery;
import com.example.exambackend.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

public class ProductOrderDto {
    private Long id;

    private int quantity;

    private Delivery delivery;

    private Product product;
}
