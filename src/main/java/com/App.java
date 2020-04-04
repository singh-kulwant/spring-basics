package com;


import com.config.AppConfig;
import com.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        System.out.println(orderService == null ? "NULL" : "OK");

        AppConfig.Worker worker = context.getBean(AppConfig.Worker.class);
        worker.execute();
    }
}
