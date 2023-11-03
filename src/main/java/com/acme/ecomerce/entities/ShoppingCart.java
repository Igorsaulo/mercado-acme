package com.acme.ecomerce.entities;

import org.hibernate.type.descriptor.java.ShortJavaType;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shoppingCartId;

    @Column(name = "shopping_cart_user_id")
    private Long shoppingCartUserId;

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "total_items")
    private Integer totalItems;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public ShoppingCart() {
    }

    public ShoppingCart(
            Long shoppingCartId,
            Long shoppingCartUserId,
            BigDecimal totalPrice,
            Integer totalItems,
            Customer customer
    ) {
        this.shoppingCartId = shoppingCartId;
        this.shoppingCartUserId = shoppingCartUserId;
        this.totalPrice = totalPrice;
        this.totalItems = totalItems;
        this.customer = customer;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Long getShoppingCartUserId() {
        return shoppingCartUserId;
    }

    public void setShoppingCartUserId(Long shoppingCartUserId) {
        this.shoppingCartUserId = shoppingCartUserId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}