package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    private String username;

    @Column(unique = true, nullable = false, name = "password_hash")
    private String password;

    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;
    private String address;

    private String avatar;

    private Boolean status;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRole> userRoles;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<ShoppingCart> shoppingCarts;
}