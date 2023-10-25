package com.acme.ecomerce.repositories;

import com.acme.ecomerce.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ShoppingCartRepository
    extends JpaRepository <ShoppingCart, Long> {
    }
