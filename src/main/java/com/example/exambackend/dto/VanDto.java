package com.example.exambackend.dto;

import com.example.exambackend.model.Delivery;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class VanDto {
    private Long id;

    private String brand;

    private String model;

    private int capacity;

    private List<Delivery> deliveryList;
}
