package com.example.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductionBrands implements Serializable {
    private int brand_id;
    private String brandName;

//CREATE TABLE production.brands (
//	brand_id INT IDENTITY (1, 1) PRIMARY KEY,
//	brand_name VARCHAR (255) NOT NULL
//);
}
