package com.example.exambackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Delivery {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate deliveryDate;

    private String fromWareHouse;

    private String destination;

    @JsonIgnore
    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<ProductOrder> productOrderList;

    public Delivery(LocalDate deliveryDate, String fromWareHouse, String destination) {
        this.deliveryDate = deliveryDate;
        this.fromWareHouse = fromWareHouse;
        this.destination = destination;
    }
}
