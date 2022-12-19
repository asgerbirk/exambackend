package com.example.exambackend.controller;

import com.example.exambackend.dto.ProductOrderDto;
import com.example.exambackend.dto.VanDto;
import com.example.exambackend.service.ProductOrderService;
import com.example.exambackend.service.VanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/vans")
public class VanController {
    private final VanService vanService;


    public VanController(VanService vanService) {
        this.vanService = vanService;
    }

    @GetMapping
    public ResponseEntity<List<VanDto>> getAll(){
        return ResponseEntity.ok().body(vanService.allVans());
    }


    @PostMapping
    public ResponseEntity<VanDto> create(@Valid @RequestBody VanDto vanDto){
        return ResponseEntity.ok().body(vanService.saveVan(vanDto));
    }
}
