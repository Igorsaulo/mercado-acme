package com.acme.ecomerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long shopping_cart_id;
    public long shopping_cart_user_id;
    public long total_price;
    public long total_items;

    @OneToOne
    @JoinColumn(name = "customer_id")
    public Customer customer;
}
