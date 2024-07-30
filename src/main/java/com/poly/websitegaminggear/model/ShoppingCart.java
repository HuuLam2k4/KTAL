package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Shopping_Cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int shoppingCartId;
    private Date create_at;
    private Date update_at;

    @ManyToOne
    @JoinColumn(name = "username")
    private User users;

    @OneToMany(mappedBy = "shoppingCarts")
    private List<CartItem> cartItems;
}
