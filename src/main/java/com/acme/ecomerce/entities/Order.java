package com.acme.ecomerce.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_user_id")
    private Long orderUserId;

    @Column(name = "order_total_price", precision = 10, scale = 2)
    private BigDecimal orderTotalPrice;

    @Column(name = "order_total_items")
    private Integer orderTotalItems;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    public Order() {
    }

    public Order(
            Long orderId,
            Long orderUserId,
            BigDecimal orderTotalPrice,
            Integer orderTotalItems,
            Customer customer,
            Seller seller) {
        this.orderId = orderId;
        this.orderUserId = orderUserId;
        this.orderTotalPrice = orderTotalPrice;
        this.orderTotalItems = orderTotalItems;
        this.customer = customer;
        this.seller = seller;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(Long orderUserId) {
        this.orderUserId = orderUserId;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public Integer getOrderTotalItems() {
        return orderTotalItems;
    }

    public void setOrderTotalItems(Integer orderTotalItems) {
        this.orderTotalItems = orderTotalItems;
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
