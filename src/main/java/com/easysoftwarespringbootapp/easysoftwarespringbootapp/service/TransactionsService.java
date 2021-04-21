package com.easysoftwarespringbootapp.easysoftwarespringbootapp.service;

import com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities.Customers;
import com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities.Transactions;
import com.easysoftwarespringbootapp.easysoftwarespringbootapp.models.TransactionModel;
import com.easysoftwarespringbootapp.easysoftwarespringbootapp.repositories.CustomerRepository;
import com.easysoftwarespringbootapp.easysoftwarespringbootapp.repositories.TransactionsRepository;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionsService {

    private  final TransactionsRepository transactionsRepository;
private final CustomerRepository customerRepository;

    @Transactional
    public Transactions receiveLoanRequest(Transactions transactions) {

        return transactionsRepository.save(transactions);
    }

    @Transactional
    public List<Transactions> getLoanRequests(String customerId) {
        Customers customer = customerRepository.findByCustomerId(customerId);
        return transactionsRepository.findAll().stream()
                .filter(trans -> trans.getCustomers().getCustomerId().equals(customer.getCustomerId()))
                .collect(Collectors.toList());
    }

    @Transactional
    public Transactions getOneLoan(Long id) {
        return transactionsRepository.findById(id).orElse(null);
    }


@Transactional
    public Transactions updateLoanRequests(Long id,Transactions transactions) {
        Transactions trans = transactionsRepository.findById(id).orElse(null);
        if(trans != null) {
            trans.setAmount(transactions.getAmount());
            trans.setLoanDate(transactions.getLoanDate());
            trans.setInterest(transactions.getInterest());
            trans.setLoanCode(transactions.getLoanCode());
        }
        return transactionsRepository.save(trans);
    }


    public void partiallyUpdateLoans(long id, TransactionModel transactionModel) {
        Transactions trans = transactionsRepository.findById(id).orElse(null);

        boolean needUpdate = false;

        if(StringUtils.hasLength(transactionModel.getLoanCode())){
            trans.setLoanCode(transactionModel.getLoanCode());
            needUpdate = true;
        }

        if(transactionModel.getLoanDate().equals(0)){
            trans.setLoanDate(transactionModel.getLoanDate());
            needUpdate = true;
        }

        if(transactionModel.getLoanDueDate().equals(0)){
            trans.setLoanDueDate(transactionModel.getLoanDueDate());
            needUpdate = true;
        }

//        if(transactionModel.getAmount().equals(BigDecimal.ZERO)){
//            trans.setAmount(transactionModel.getAmount());
//            needUpdate = true;
//        }
//
//        if(transactionModel.getInterest().equals(BigDecimal.ZERO)){
//            trans.setInterest(transactionModel.getInterest());
//            needUpdate = true;
//        }


        if(needUpdate){
            transactionsRepository.save(trans);
        }

    }
}
