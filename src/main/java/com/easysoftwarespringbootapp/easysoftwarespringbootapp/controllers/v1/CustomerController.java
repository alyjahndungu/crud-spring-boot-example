package com.easysoftwarespringbootapp.easysoftwarespringbootapp.controllers.v1;

import com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities.Customers;
import com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities.Transactions;
import com.easysoftwarespringbootapp.easysoftwarespringbootapp.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    //Registering a new customer endpoint
    @PostMapping
    public ResponseEntity createNewCustomer(@RequestBody Customers customers){
        customerService.createNewCustomer(customers);
        return new ResponseEntity("Created successfully", HttpStatus.CREATED);
    }

}
