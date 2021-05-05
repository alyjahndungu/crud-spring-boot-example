package com.easysoftwarespringbootapp.easysoftwarespringbootapp.repositories;

import com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities.Customers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void findByCustomerId() {
        //Given
        String customer_id = "EP-0002";
        Customers customers = new Customers(
                customer_id,
                "Elijah",
                "Ndungu",
                "0741862008"
        );
        underTest.save(customers);

        //When
        Customers exists  = underTest.findByCustomerId(customer_id);

        assertThat(exists).isEqualTo(customers);

        //Then

    }
}