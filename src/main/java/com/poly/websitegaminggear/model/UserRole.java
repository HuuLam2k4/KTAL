package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Users_Roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
}