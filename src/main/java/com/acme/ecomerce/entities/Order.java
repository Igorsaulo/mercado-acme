package com.acme.ecomerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_id;
    private long order_user_id;
    private long order_total_price;
    private long order_total_items;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    public Order() {
    }

    public Order(
        long order_id,
        long order_user_id,
        long order_total_price,
        long order_total_items,
        Customer customer,
        Seller seller) {
        this.order_id = order_id;
        this.order_user_id = order_user_id;
        this.order_total_price = order_total_price;
        this.order_total_items = order_total_items;
        this.customer = customer;
        this.seller = seller;
    }

    public long getOrder_id() {
        return order_id;
    }
    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }
    public long getOrder_user_id() {
        return order_user_id;
    }
    public void setOrder_user_id(long order_user_id) {
        this.order_user_id = order_user_id;
    }
    public long getOrder_total_price() {
        return order_total_price;
    }
    public void setOrder_total_price(long order_total_price) {
        this.order_total_price = order_total_price;
    }
    public long getOrder_total_items() {
        return order_total_items;
    }
    public void setOrder_total_items(long order_total_items) {
        this.order_total_items = order_total_items;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }
    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
