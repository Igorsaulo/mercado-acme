package com.acme.ecomerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long sale_id;
    public long sale_total_price;
    public long sale_total_items;

    @OneToOne
    @JoinColumn(name = "seller_id")
    public Seller seller;

    @OneToOne
    @JoinColumn(name = "customer_id")
    public Customer customer;
}
