package com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.corba.se.spi.ior.Identifiable;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "loan_transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "transactionId")
    @Column(unique = true)
    private String transactionId;

    @JsonProperty(value = "amount")
    private BigDecimal amount;

    @JsonProperty(value = "interest")
    private  BigDecimal interest;

    @JsonProperty(value = "loanCode")
    private String loanCode;

    @JsonProperty(value = "loanDate")
    private Date loanDate;

    @JsonProperty(value = "loanDueDate")
    private Date loanDueDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId", nullable = false)
    @JsonProperty("customer")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customers customers;

    public Transactions(Long id, String transactionId) {
        this.id = id;
        this.transactionId = transactionId;
    }

    public Transactions() {
    }
}
