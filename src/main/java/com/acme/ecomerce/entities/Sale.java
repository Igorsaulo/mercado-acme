package com.acme.ecomerce.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long saleId;

    @Column(name = "sale_total_price", precision = 10, scale = 2)
    private BigDecimal saleTotalPrice;

    @Column(name = "sale_total_items")
    private Integer saleTotalItems;

    @OneToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Sale() {
    }

    public Sale(Long saleId, BigDecimal saleTotalPrice, Integer saleTotalItems, Seller seller, Customer customer) {
        this.saleId = saleId;
        this.saleTotalPrice = saleTotalPrice;
        this.saleTotalItems = saleTotalItems;
        this.seller = seller;
        this.customer = customer;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public BigDecimal getSaleTotalPrice() {
        return saleTotalPrice;
    }

    public void setSaleTotalPrice(BigDecimal saleTotalPrice) {
        this.saleTotalPrice = saleTotalPrice;
    }

    public Integer getSaleTotalItems() {
        return saleTotalItems;
    }

    public void setSaleTotalItems(Integer saleTotalItems) {
        this.saleTotalItems = saleTotalItems;
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
