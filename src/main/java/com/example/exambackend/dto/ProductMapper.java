package com.example.exambackend.dto;

import com.example.exambackend.model.Product;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProductMapper {

    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public ProductDto productToDto(Product product){
        return modelMapper.map(product,ProductDto.class);
    }

    public Product dtoToProduct(ProductDto productDto){
        return modelMapper.map(productDto, Product.class);
    }
}
