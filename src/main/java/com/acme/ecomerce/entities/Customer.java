package com.acme.ecomerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long customer_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    public User user;
}
