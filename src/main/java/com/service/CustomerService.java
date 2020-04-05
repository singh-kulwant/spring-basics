package com.service;

import com.aspect.AroundLoggable;
import com.aspect.Loggable;
import com.data.entity.Customer;
import com.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Loggable
    @AroundLoggable
    public List<Customer> getAll(){
        return (List<Customer>) customerRepository.findAll();
    }

    @Loggable
    @AroundLoggable
    public Optional<Customer> findOne(String id){ return customerRepository.findById(id); }
}
