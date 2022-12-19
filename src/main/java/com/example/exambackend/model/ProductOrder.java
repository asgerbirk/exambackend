package com.example.exambackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    private Delivery delivery;

    @ManyToOne
    private Product product;

    public ProductOrder(int quantity, Delivery delivery, Product product) {
        this.quantity = quantity;
        this.delivery = delivery;
        this.product = product;
    }
}
