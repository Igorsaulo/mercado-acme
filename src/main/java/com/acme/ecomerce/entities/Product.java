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

    public Product(){
    }

    public Product(
        long product_id,
        String product_name,
        String product_description,
        String product_image,
        String product_category,
        long product_price,
        long product_stock,
        Sale sale,
        ShoppingCart shoppingCart,
        Seller seller
    ){
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_image = product_image;
        this.product_category = product_category;
        this.product_price = product_price;
        this.product_stock = product_stock;
        this.sale = sale;
        this.shoppingCart = shoppingCart;
        this.seller = seller;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public long getProduct_price() {
        return product_price;
    }

    public void setProduct_price(long product_price) {
        this.product_price = product_price;
    }

    public long getProduct_stock() {
        return product_stock;
    }

    public void setProduct_stock(long product_stock) {
        this.product_stock = product_stock;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    

}
