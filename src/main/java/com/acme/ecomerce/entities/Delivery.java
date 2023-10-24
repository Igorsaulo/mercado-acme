package com.acme.ecomerce.entities;

import jakarta.persistence.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long delivery_id;
    public Date delivery_date;
    public Date previous_delivery_date;
    public Date next_delivery_date;

    @OneToOne
    @JoinColumn(name = "sale_id")
    public Sale sale;
}
