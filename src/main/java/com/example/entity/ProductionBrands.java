package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ProductionBrands implements Serializable {
    private String brandName;

//CREATE TABLE production.brands (
//	brand_id INT IDENTITY (1, 1) PRIMARY KEY,
//	brand_name VARCHAR (255) NOT NULL
//);
}
