package com.acme.ecomerce.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long deliveryId;

    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @Column(name = "previous_delivery_date")
    @Temporal(TemporalType.DATE)
    private Date previousDeliveryDate;

    @Column(name = "next_delivery_date")
    @Temporal(TemporalType.DATE)
    private Date nextDeliveryDate;

    @OneToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    public Delivery() {
    }

    public Delivery(
            Long deliveryId,
            Date deliveryDate,
            Date previousDeliveryDate,
            Date nextDeliveryDate,
            Sale sale) {
        this.deliveryId = deliveryId;
        this.deliveryDate = deliveryDate;
        this.previousDeliveryDate = previousDeliveryDate;
        this.nextDeliveryDate = nextDeliveryDate;
        this.sale = sale;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getPreviousDeliveryDate() {
        return previousDeliveryDate;
    }

    public void setPreviousDeliveryDate(Date previousDeliveryDate) {
        this.previousDeliveryDate = previousDeliveryDate;
    }

    public Date getNextDeliveryDate() {
        return nextDeliveryDate;
    }

    public void setNextDeliveryDate(Date nextDeliveryDate) {
        this.nextDeliveryDate = nextDeliveryDate;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
