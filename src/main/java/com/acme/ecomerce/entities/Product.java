package com.acme.ecomerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long product_id;
    public String product_name;
    public String product_description;
    public String product_image;
    public String product_category;
    public long product_price;
    public long product_stock;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    public Sale sale;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    public ShoppingCart shoppingCart;

    @OneToOne
    @JoinColumn(name = "seller_id")
    public Seller seller;
}
