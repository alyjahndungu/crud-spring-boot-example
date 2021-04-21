package com.easysoftwarespringbootapp.easysoftwarespringbootapp.controllers.v1;


import com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities.Customers;
import com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities.Transactions;
import com.easysoftwarespringbootapp.easysoftwarespringbootapp.models.TransactionModel;
import com.easysoftwarespringbootapp.easysoftwarespringbootapp.repositories.CustomerRepository;
import com.easysoftwarespringbootapp.easysoftwarespringbootapp.service.TransactionsService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.validation.Validator;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/loans")
public class TransactionsController {

    private final TransactionsService transactionsService;
    private  final CustomerRepository customerRepository;


    //Requesting a loan endpoint
    @PostMapping(value = "/requests")
    public ResponseEntity createLoanRequests(@RequestParam String customerId,
                                             @RequestBody Transactions transactions){
        Customers customer = customerRepository.findByCustomerId(customerId);
        transactions.setCustomers(customer);
        transactionsService.receiveLoanRequest(transactions);
        return new ResponseEntity("Created successfully", HttpStatus.CREATED);
    }

    //Get single customers loan requests end point
    @GetMapping(value = "/requests")
    public ResponseEntity<List<Transactions>> getCustomerLoans(
            @RequestParam String customerId){
        return new ResponseEntity(transactionsService.getLoanRequests(customerId), HttpStatus.OK);

    }

    //Updating loans request endpoint
    @PutMapping(value = "/requests")
    public ResponseEntity<?> updateCustomerLoans(
            @RequestParam Long id,
            @RequestBody Transactions transactions){
                transactionsService.updateLoanRequests(id, transactions);
        return ResponseEntity.ok("Loan has been updated");

    }

    //Retrieving one loan request by id
    @GetMapping
    public ResponseEntity getOneLoan(
            @RequestParam Long id){
        return new ResponseEntity(transactionsService.getOneLoan(id), HttpStatus.OK);

    }


    //Patching Transactions
    @PatchMapping("/requests/{id}")
    public ResponseEntity patchLoans(@PathVariable long id,
                                     @RequestBody TransactionModel transactionModel){
        transactionsService.partiallyUpdateLoans(id, transactionModel);

        return ResponseEntity.ok("Loan has been partially updated");
    }




}
