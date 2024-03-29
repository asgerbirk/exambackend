package com.example.exambackend;

import com.example.exambackend.model.Delivery;
import com.example.exambackend.model.Product;
import com.example.exambackend.model.ProductOrder;
import com.example.exambackend.model.Van;
import com.example.exambackend.repository.DeliveryRepository;
import com.example.exambackend.repository.ProductOrderRepository;
import com.example.exambackend.repository.ProductRepository;
import com.example.exambackend.repository.VanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ExambackendApplication {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(ExambackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData(DeliveryRepository deliveryRepository,
                                        ProductRepository productRepository,
                                        ProductOrderRepository productOrderRepository,
                                        VanRepository vanRepository){
        return (args -> {
            final List<Product> products = new ArrayList<>();
            final List<Delivery> deliveries = new ArrayList<>();
            final List<ProductOrder> productOrderList = new ArrayList<>();
            final List<Van> vanList = new ArrayList<>();

            vanList.add(new Van("bmw", "c5", 100));
            vanList.add(new Van("audi", "b4", 200));
            vanList.add(new Van("volvo", "v3", 300));
            vanList.add(new Van("citro", "x1", 400));
            vanRepository.saveAll(vanList);


            products.add(new Product("sodavand", 10, 80));
            products.add(new Product("øl", 50, 11));
            products.add(new Product("popcorn", 20, 10));
            products.add(new Product("chips", 100, 20));
            products.add(new Product("brød", 1000, 60));
            productRepository.saveAll(products);

            deliveries.add(new Delivery(LocalDate.of(2022, Month.DECEMBER, 18), "w1", "heimdalsgade 12A ",vanList.get(2)));
            deliveries.add(new Delivery(LocalDate.of(2022, Month.DECEMBER,17), "w2", "Nebbegårdsbakken 38 ",vanList.get(1)));
            deliveries.add(new Delivery(LocalDate.of(2002,Month.DECEMBER,16), "w3", "Nørrebrogade 35 ", vanList.get(0)));
            deliveryRepository.saveAll(deliveries);

            productOrderList.add(new ProductOrder(5, deliveries.get(0),products.get(4)));
            productOrderList.add(new ProductOrder(10, deliveries.get(1),products.get(2)));
            productOrderList.add(new ProductOrder(20, deliveries.get(2),products.get(0)));
            productOrderRepository.saveAll(productOrderList);

        });
    }

}
