package com.example.exambackend.service;
import com.example.exambackend.dto.DeliveryDto;
import com.example.exambackend.dto.DeliveryMapper;
import com.example.exambackend.model.Delivery;
import com.example.exambackend.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;

    public DeliveryService(DeliveryRepository deliveryRepository, DeliveryMapper deliveryMapper) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryMapper = deliveryMapper;
    }

    public DeliveryDto saveDelivery(DeliveryDto deliveryDto){
        Delivery delivery = deliveryMapper.dtoToDelivery(deliveryDto);
        return deliveryMapper.deliveryToDto(deliveryRepository.save(delivery));
    }

    public List<DeliveryDto> getAllDeliveries(){
        return deliveryRepository
                .findAll()
                .stream()
                .map(deliveryMapper::deliveryToDto)
                .collect(Collectors.toList());
    }
}
