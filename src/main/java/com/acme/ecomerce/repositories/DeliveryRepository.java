package com.acme.ecomerce.repositories;

import com.acme.ecomerce.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DeliveryRepository
    extends JpaRepository <Delivery, Long> {
}
