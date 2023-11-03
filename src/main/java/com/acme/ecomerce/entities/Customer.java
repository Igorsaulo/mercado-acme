package com.acme.ecomerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long customerId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Customer (){
    }

    public Customer(
            long customerId,
            User user) {
        this.customerId = customerId;
        this.user = user;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
