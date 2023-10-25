package com.acme.ecomerce.entities;

import org.hibernate.type.descriptor.java.ShortJavaType;

import jakarta.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long shopping_cart_id;
    public long shopping_cart_user_id;
    public long total_price;
    public long total_items;

    @OneToOne
    @JoinColumn(name = "customer_id")
    public Customer customer;

    public ShoppingCart(){
    }

    public ShoppingCart(
        long shopping_cart_id,
        long shopping_cart_user_id,
        long total_price,
        long total_items,
        Customer customer
    ){
        this.shopping_cart_id = shopping_cart_id;
        this.shopping_cart_user_id = shopping_cart_user_id;
        this.total_price = total_price;
        this.total_items = total_items;
        this.customer = customer;
    }

    public long getShopping_cart_id() {
        return shopping_cart_id;
    }

    public void setShopping_cart_id(long shopping_cart_id) {
        this.shopping_cart_id = shopping_cart_id;
    }

    public long getShopping_cart_user_id() {
        return shopping_cart_user_id;
    }

    public void setShopping_cart_user_id(long shopping_cart_user_id) {
        this.shopping_cart_user_id = shopping_cart_user_id;
    }

    public long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(long total_price) {
        this.total_price = total_price;
    }

    public long getTotal_items() {
        return total_items;
    }

    public void setTotal_items(long total_items) {
        this.total_items = total_items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    

}
