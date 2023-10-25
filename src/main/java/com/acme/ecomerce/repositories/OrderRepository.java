package com.acme.ecomerce.repositories;
import com.acme.ecomerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository
        extends JpaRepository <Order, Long> {
}