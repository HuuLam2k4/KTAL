package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    private String username;
    private String password_hash;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String address;
    private Date create_at;
    private Date update_at;
    private String avatar;
    private boolean status;

    @OneToMany(mappedBy = "user")
    private List<ShoppingCart> shoppingCarts;


}
