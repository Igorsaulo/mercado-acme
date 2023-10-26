package com.acme.ecomerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Customer (){
    }

    public Customer(
            long customer_id,
            User user) {
        this.customer_id = customer_id;
        this.user = user;
    }

    public long getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
