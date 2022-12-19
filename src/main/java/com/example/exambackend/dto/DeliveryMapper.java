package com.example.exambackend.dto;

import com.example.exambackend.model.Delivery;
import com.example.exambackend.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DeliveryMapper {

    private final ModelMapper modelMapper;

    public DeliveryMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public DeliveryDto deliveryToDto(Delivery delivery){
        return modelMapper.map(delivery,DeliveryDto.class);
    }

    public Delivery dtoToDelivery(DeliveryDto deliveryDto){
        return modelMapper.map(deliveryDto, Delivery.class);
    }
}
