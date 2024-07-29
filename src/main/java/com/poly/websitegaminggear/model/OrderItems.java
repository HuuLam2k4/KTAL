package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Order_Items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int order_id;
    Date order_date;
    int order_item_id;
    int quantity;
    Double price;
    Date updated_at;
    int order_id;
    int product_id;
}


