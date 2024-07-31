package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int review_id;
    private int rating;
    private String comment;
    private Date create_at;
    private Date update_at;

    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    private ProductDetail productDetails;

    @ManyToOne
    @JoinColumn(name = "username")
    private User users;
}
