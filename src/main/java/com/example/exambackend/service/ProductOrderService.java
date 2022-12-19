package com.example.exambackend.service;


import com.example.exambackend.dto.ProductOrderDto;
import com.example.exambackend.dto.ProductOrderMapper;

import com.example.exambackend.model.ProductOrder;
import com.example.exambackend.repository.ProductOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOrderService {

    private final ProductOrderMapper productOrderMapper;
    private final ProductOrderRepository productOrderRepository;

    public ProductOrderService(ProductOrderMapper productOrderMapper, ProductOrderRepository productOrderRepository) {
        this.productOrderMapper = productOrderMapper;
        this.productOrderRepository = productOrderRepository;
    }

    public ProductOrderDto saveProductOrder(ProductOrderDto productOrderDto){
        ProductOrder productOrder = productOrderMapper.dtoToProductOrder(productOrderDto);
        return productOrderMapper.productOrderToDto(productOrderRepository.save(productOrder));
    }

    public List<ProductOrderDto> getAllProducts(){
        return productOrderRepository
                .findAll()
                .stream()
                .map(productOrderMapper::productOrderToDto)
                .collect(Collectors.toList());
    }
}
