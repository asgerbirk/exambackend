package com.example.exambackend.dto;

import com.example.exambackend.model.ProductOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    private Long id;

    private String name;
    private int price;
    private int weight;


    private List<ProductOrder> productOrderList;
}
