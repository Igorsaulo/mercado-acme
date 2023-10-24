package com.acme.ecomerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long order_id;
    public long order_user_id;
    public long order_total_price;
    public long order_total_items;

    @OneToOne
    @JoinColumn(name = "customer_id")
    public Customer customer;

    @OneToOne
    @JoinColumn(name = "seller_id")
    public Seller seller;
}
