package com.example.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SalesCustomers implements Serializable {
    private int customerId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String street;
    private String city;
    private String state;
    private String zipCode;

//    CREATE TABLE sales.customers (
//    customer_id INT IDENTITY (1, 1) PRIMARY KEY,
//    first_name VARCHAR (255) NOT NULL,
//    last_name VARCHAR (255) NOT NULL,
//    phone VARCHAR (25),
//    email VARCHAR (255) NOT NULL,
//    street VARCHAR (255),
//    city VARCHAR (50),
//    state VARCHAR (25),
//    zip_code VARCHAR (5)

}
