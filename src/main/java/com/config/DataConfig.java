package com.config;

import com.data.repository.CustomerRepository;
import com.data.repository.InventoryItemRepository;
import com.data.repository.SalesOrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

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
