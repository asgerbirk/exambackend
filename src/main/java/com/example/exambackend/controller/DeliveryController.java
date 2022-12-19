package com.example.exambackend.controller;

import com.example.exambackend.dto.DeliveryDto;
import com.example.exambackend.dto.ProductDto;
import com.example.exambackend.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public ResponseEntity<List<DeliveryDto>> getAll(){
        return ResponseEntity.ok().body(deliveryService.getAllDeliveries());
    }

    @PostMapping
    public ResponseEntity<DeliveryDto> create(@Valid @RequestBody DeliveryDto deliveryDto){
        return ResponseEntity.ok().body(deliveryService.saveDelivery(deliveryDto));
    }
}
