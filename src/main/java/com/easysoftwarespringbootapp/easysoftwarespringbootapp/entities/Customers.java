package com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "customerId")
    @Column(unique = true)
    private String customerId;

    @JsonProperty(value = "firstname")
    private String firstname;

    @JsonProperty(value = "lastname")
    private String lastname;

    @JsonProperty(value = "phoneNo")
    private String phoneNo;

    public Customers() {
    }

    public Customers(String customerId, String firstname, String lastname, String phoneNo) {
        this.customerId = customerId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNo = phoneNo;
    }
}
