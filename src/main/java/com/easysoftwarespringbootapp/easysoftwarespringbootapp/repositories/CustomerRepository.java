package com.easysoftwarespringbootapp.easysoftwarespringbootapp.repositories;

import com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, String> {

    Customers findByCustomerId(String customerId);
}
