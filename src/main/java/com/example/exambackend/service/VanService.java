package com.example.exambackend.service;

import com.example.exambackend.dto.VanDto;
import com.example.exambackend.dto.VanMapper;
import com.example.exambackend.model.Van;
import com.example.exambackend.repository.VanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VanService {

    private final VanRepository vanRepository;

    private final VanMapper vanMapper;


    private final ProductService productService;

    public VanService(VanRepository vanRepository, VanMapper vanMapper, ProductService productService) {
        this.vanRepository = vanRepository;
        this.vanMapper = vanMapper;
        this.productService = productService;
    }

    public List<VanDto> allVans(){
        return vanRepository.findAll().stream().map(vanMapper::vanToDto).collect(Collectors.toList());
    }

    public VanDto saveVan(VanDto vanDto){
        Van van = vanMapper.dtoToVan(vanDto);
        for (int i = 0; i < productService.getAllProducts().size(); i++) {
            if (van.getCapacity() <= productService.getAllProducts().get(i).getWeight()){
                throw new IllegalStateException("no capacity ");
            }
        }
        return vanMapper.vanToDto(vanRepository.save(van));
    }

}
