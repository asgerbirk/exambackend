package com.example.exambackend.controller;

import com.example.exambackend.dto.ProductDto;
import com.example.exambackend.dto.ProductOrderDto;
import com.example.exambackend.service.ProductOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/productOrders")
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping
    public ResponseEntity<List<ProductOrderDto>> getAll(){
        return ResponseEntity.ok().body(productOrderService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductOrderDto> create(@Valid @RequestBody ProductOrderDto productOrderDto){
        return ResponseEntity.ok().body(productOrderService.saveProductOrder(productOrderDto));
    }


}
