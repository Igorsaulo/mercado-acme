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

    public Seller(){
    }

    public Seller(
        long seller_id,
        User user
    ){
        this.seller_id = seller_id;
        this.user = user;
    }

    public long getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(long seller_id) {
        this.seller_id = seller_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}
