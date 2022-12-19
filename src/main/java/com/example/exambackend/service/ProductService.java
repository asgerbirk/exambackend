package com.example.exambackend.service;

import com.example.exambackend.dto.ProductDto;
import com.example.exambackend.dto.ProductMapper;
import com.example.exambackend.model.Product;
import com.example.exambackend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDto saveProduct(ProductDto productDto){
        Product product = productMapper.dtoToProduct(productDto);
        return productMapper.productToDto(productRepository.save(product));
    }

    public List<ProductDto> getAllProducts(){
        return productRepository
                .findAll()
                .stream()
                .map(productMapper::productToDto)
                .collect(Collectors.toList());
    }

    public ProductDto findProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(()->new IllegalStateException("no product with that id" + id));
        return productMapper.productToDto(product);
    }

    public ProductDto findByName(String name){
        Product product = productRepository.findByName(name);
        return productMapper.productToDto(product);
    }

    public ProductDto update(Long id, ProductDto updatedProduct){
        Product product = productRepository.findById(id).orElseThrow(()->new IllegalStateException("no product with that id" + id));
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setWeight(updatedProduct.getWeight());
        productRepository.save(product);
        return productMapper.productToDto(product);
    }

    public void deleteProduct(Long id){
        boolean checkIfProductExist = productRepository.existsById(id);
        if (!checkIfProductExist){
            throw new IllegalStateException("does not exists " + id);
        }
        productRepository.deleteById(id);
    }

}
