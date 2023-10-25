package com.acme.ecomerce.entities;

import jakarta.persistence.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long delivery_id;
    private Date delivery_date;
    private Date previous_delivery_date;
    private Date next_delivery_date;

    @OneToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    public Delivery() {
    }
    public  Delivery(
        long delivery_id,
        Date delivery_date,
        Date previous_delivery_date,
        Date next_delivery_date,
        Sale sale) {
        this.delivery_id = delivery_id;
        this.delivery_date = delivery_date;
        this.previous_delivery_date = previous_delivery_date;
        this.next_delivery_date = next_delivery_date;
        this.sale = sale;
    }

    public long getDelivery_id() {
        return delivery_id;
    }
    public void setDelivery_id(long delivery_id) {
        this.delivery_id = delivery_id;
    }
    public Date getDelivery_date() {
        return delivery_date;
    }
    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }
    public Date getPrevious_delivery_date() {
        return previous_delivery_date;
    }
    public void setPrevious_delivery_date(Date previous_delivery_date) {
        this.previous_delivery_date = previous_delivery_date;
    }
    public Date getNext_delivery_date() {
        return next_delivery_date;
    }
    public void setNext_delivery_date(Date next_delivery_date) {
        this.next_delivery_date = next_delivery_date;
    }
    public Sale getSale() {
        return sale;
    }
    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
