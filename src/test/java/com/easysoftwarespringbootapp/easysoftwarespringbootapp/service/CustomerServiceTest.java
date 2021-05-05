package com.easysoftwarespringbootapp.easysoftwarespringbootapp.service;

import com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities.Customers;
import com.easysoftwarespringbootapp.easysoftwarespringbootapp.repositories.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock private CustomerRepository customerRepository;

@Autowired
private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }


    @Test
    void  canGetAllCustomers(){
        //while
       underTest.getAllCustomers();
        //then
        verify(customerRepository).findAll();
    }

    @Test
    void canCreateNewCustomer() {

        //Given
        String customer_id = "EP-0002";
        Customers customers = new Customers(
                customer_id,
                "Elijah",
                "Ndungu",
                "0741862008"
        );

        //When
        underTest.createNewCustomer(customers);

        //Then

        ArgumentCaptor<Customers> customersArgumentCaptor =
                ArgumentCaptor.forClass(Customers.class);

        verify(customerRepository).save(customersArgumentCaptor.capture());

        Customers capturedCustomer = customersArgumentCaptor.getValue();

        assertThat(capturedCustomer).isEqualTo(customers);


    }
}