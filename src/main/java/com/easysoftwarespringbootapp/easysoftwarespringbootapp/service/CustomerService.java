package com.easysoftwarespringbootapp.easysoftwarespringbootapp.service;

import com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities.Customers;
import com.easysoftwarespringbootapp.easysoftwarespringbootapp.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public Customers createNewCustomer(Customers customers) {
        return  customerRepository.save(customers);
    }

    @Transactional
    public List<Customers> getAllCustomers(){
        return customerRepository.findAll();
    }

}
