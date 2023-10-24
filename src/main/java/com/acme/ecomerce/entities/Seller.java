package com.acme.ecomerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long seller_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    public User user;
}
