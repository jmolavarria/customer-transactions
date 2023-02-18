package com.example.demo.core.service;

import com.example.demo.core.entity.Customer;
import com.example.demo.core.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public Optional<Customer> find(Long id) {
        return customerRepository.findById(id);
    }
}
