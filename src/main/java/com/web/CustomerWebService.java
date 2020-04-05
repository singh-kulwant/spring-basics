package com.web;

import com.data.entity.Customer;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController("/")
public class CustomerWebService {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAll(){
        return this.customerService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getOne(@PathVariable("id")String id){
        return this.customerService.findOne(id);
    }
}
