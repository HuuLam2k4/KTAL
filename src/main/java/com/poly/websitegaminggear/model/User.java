package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String username;
    String password_hash;
    String first_name;
    String last_name;
    String email;
    String phone_number;
    String address;
    Date create_at;
    Date update_at;
    String avatar;
    boolean status;

}
