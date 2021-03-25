package com.example.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductionBrands implements Serializable {
    private int brand_id;
    private String brandName;
}
