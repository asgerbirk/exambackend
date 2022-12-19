package com.example.exambackend.dto;

import com.example.exambackend.model.ProductOrder;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
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

    private List<ProductOrder> productOrderList;
}
