package com.config;


import com.data.repository.CustomerRepository;
import com.data.repository.InventoryItemRepository;
import com.data.repository.SalesOrderRepository;
import com.service.InventoryService;
import com.service.impl.InventoryServiceImpl;
import com.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@Import(DataConfig.class)
@PropertySource("classpath:/application.yml")
public class AppConfig {

    @Value("${application.name}")
    private String applicationName;

    public class Worker {
        private String active;
        private String text;

        Worker(String active, String text) {
            this.active = active;
            this.text = text;
        }

        public void execute() {
            System.out.println("Welcome to " + active + "-" + text);
        }
    }

    @Bean
    @Profile("dev")
    public Worker workerForDev() {
        return new Worker("dev", applicationName);
    }

    @Bean
    @Profile("prod")
    public Worker workerForProd() {
        return new Worker("prod", applicationName);
    }

    @Bean
    public OrderServiceImpl orderService(InventoryService inventoryService, CustomerRepository customerRepository, SalesOrderRepository salesOrderRepository) {
        return new OrderServiceImpl(inventoryService, customerRepository, salesOrderRepository);
    }

    @Bean
    public InventoryService inventoryService(InventoryItemRepository inventoryItemRepository) {
        return new InventoryServiceImpl(inventoryItemRepository);
    }
}

