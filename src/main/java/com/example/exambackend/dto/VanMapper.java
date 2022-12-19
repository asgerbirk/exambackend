package com.example.exambackend.dto;

import com.example.exambackend.model.ProductOrder;
import com.example.exambackend.model.Van;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VanMapper {
    private final ModelMapper modelMapper;

    public VanMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VanDto vanToDto(Van van){
        return modelMapper.map(van,VanDto.class);
    }

    public Van dtoToVan(VanDto vanDto){
        return modelMapper.map(vanDto, Van.class);
    }
}
