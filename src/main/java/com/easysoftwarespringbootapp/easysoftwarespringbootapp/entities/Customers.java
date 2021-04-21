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

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "phoneNo")
    private String phoneNo;

}
