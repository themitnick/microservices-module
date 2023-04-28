package com.themitnick.inventoryservice;

import com.themitnick.inventoryservice.model.Inventory;
import com.themitnick.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {

            Inventory inventory = Inventory.builder()
                    .skuCode("Test1")
                    .quantity(3)
                    .build();

            Inventory inventory1 = Inventory.builder()
                    .skuCode("Test2")
                    .quantity(0)
                    .build();

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1);

        };
    }

}
