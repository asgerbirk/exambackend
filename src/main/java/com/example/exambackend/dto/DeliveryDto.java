package com.example.exambackend.dto;

import com.example.exambackend.model.ProductOrder;
import com.example.exambackend.model.Van;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DeliveryDto {

    private Long id;

    private LocalDate deliveryDate;

    private String fromWareHouse;

    private String destination;

    private Van van;

    private List<ProductOrder> productOrderList;
}
