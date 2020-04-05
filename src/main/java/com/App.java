package com;


import com.config.AppConfig;
import com.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        /*ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        System.out.println("Order Service: "+orderService == null ? "NULL" : "OK");

        AppConfig.Worker worker = context.getBean(AppConfig.Worker.class);
        worker.execute();
        AppConfig.Worker worker1 = context.getBean(AppConfig.Worker.class);
        worker1.execute();
*/
    }
}
