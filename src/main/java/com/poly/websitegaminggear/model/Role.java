package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    @Column(unique = true, nullable = false)
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;

}