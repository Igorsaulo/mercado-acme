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

    private long getCustomer_id() {
        return customer_id;
    }
    private void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }
    private User getUser() {
        return user;
    }
    private void setUser(User user) {
        this.user = user;
    }

  public Customer (){
  }

  public Customer(
    long customer_id,
    User user) {
      this.customer_id = customer_id;
      this.user = user;
  }
}
