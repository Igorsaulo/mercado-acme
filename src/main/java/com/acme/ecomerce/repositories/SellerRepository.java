package com.acme.ecomerce.repositories;

import com.acme.ecomerce.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SellerRepository
        extends JpaRepository <Seller, Long> {
}
