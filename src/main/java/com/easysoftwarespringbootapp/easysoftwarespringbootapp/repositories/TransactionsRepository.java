package com.easysoftwarespringbootapp.easysoftwarespringbootapp.repositories;

import com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

    Optional<Transactions> findById(Long id);
}
