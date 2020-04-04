package com.config;


import com.data.repository.CustomerRepository;
import com.data.repository.InventoryItemRepository;
import com.data.repository.SalesOrderRepository;
import com.service.InventoryService;
import com.service.impl.InventoryServiceImpl;
import com.service.impl.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public OrderServiceImpl orderService(InventoryService inventoryService, CustomerRepository customerRepository, SalesOrderRepository salesOrderRepository) {
        return new OrderServiceImpl(inventoryService, customerRepository, salesOrderRepository);
    }

    @Bean
    public InventoryService inventoryService(InventoryItemRepository inventoryItemRepository) {
        return new InventoryServiceImpl(inventoryItemRepository);
    }

    @Bean
    public InventoryItemRepository inventoryItemRepository() {
        return new InventoryItemRepository();
    }

    @Bean
    public CustomerRepository customerRepository() {
        return new CustomerRepository();
    }

    @Bean
    public SalesOrderRepository salesOrderRepository() {
        return new SalesOrderRepository();
    }
}

