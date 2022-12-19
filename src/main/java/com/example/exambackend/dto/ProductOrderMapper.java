package com.example.exambackend.dto;

import com.example.exambackend.model.Product;
import com.example.exambackend.model.ProductOrder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductOrderMapper {
    private final ModelMapper modelMapper;

    public ProductOrderMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public ProductOrderDto productOrderToDto(ProductOrder productOrder){
        return modelMapper.map(productOrder,ProductOrderDto.class);
    }

    public ProductOrder dtoToProductOrder(ProductOrderDto productOrderDto){
        return modelMapper.map(productOrderDto, ProductOrder.class);
    }
}
