package com.easysoftwarespringbootapp.easysoftwarespringbootapp.models;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransactionModel {

    private String transactionId;

    private BigDecimal amount;

    private  BigDecimal interest;

    private String loanCode;

    private Date loanDate;

    private Date loanDueDate;

}
