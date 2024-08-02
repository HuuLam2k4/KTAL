package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Users")
public class User {

    @Id
    private String username;

    private String passwordHash;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;
    private String address;

    private String avatar;

    private Boolean status;

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<ShoppingCart> shoppingCarts;
}