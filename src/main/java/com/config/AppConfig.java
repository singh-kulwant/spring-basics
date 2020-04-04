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
@PropertySource("classpath:/application-${spring.profiles.active}.yml")
public class AppConfig {

    @Value("${application.name}")
    private String applicationName;

    @Value("${profile}")
    private String active;

    @Value("#{new Boolean(environment['spring.profiles.active']=='dev')}")
    private boolean isDev;

    public class Worker {
        private String text;

        Worker(String text) {
            this.text = text;
        }

        public void execute() {
            System.out.println("Welcome to " + active + "-" + text+" isDev: "+isDev);
        }
    }

    @Bean
    public Worker worker() {
        return new Worker(applicationName);
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

