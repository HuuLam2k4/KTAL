package com.poly.websitegaminggear.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String productName;
    private String description;
    private String imageName;
    private Integer categoryId;
    private double price;
    private Integer quantity;
    private Integer supplierId;
    private Integer colorId;
    private Integer capacityId;
}
