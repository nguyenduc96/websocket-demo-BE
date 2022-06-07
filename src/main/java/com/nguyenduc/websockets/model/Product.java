package com.nguyenduc.websockets.model;

import lombok.Data;

@Data
public class Product {
    private  Long id = 0L;

    private String name;

    private double price;

    private String description;
}
