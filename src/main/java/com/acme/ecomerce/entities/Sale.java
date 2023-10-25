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

    public Sale(){
    }

    public Sale(
        long sale_id,
        long sale_total_price,
        long sale_total_items, 
        Seller seller,
        Customer customer
    ){
        this.sale_id = sale_id;
        this.sale_total_price = sale_total_price;
        this.sale_total_items = sale_total_items;
        this.seller = seller;
        this.customer = customer;
    }

    public long getSale_id() {
        return sale_id;
    }

    public void setSale_id(long sale_id) {
        this.sale_id = sale_id;
    }

    public long getSale_total_price() {
        return sale_total_price;
    }

    public void setSale_total_price(long sale_total_price) {
        this.sale_total_price = sale_total_price;
    }

    public long getSale_total_items() {
        return sale_total_items;
    }

    public void setSale_total_items(long sale_total_items) {
        this.sale_total_items = sale_total_items;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
}
