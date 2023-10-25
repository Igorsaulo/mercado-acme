package com.acme.ecomerce.repositories;

import com.acme.ecomerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository
    extends JpaRepository <Product, Long> {
}
