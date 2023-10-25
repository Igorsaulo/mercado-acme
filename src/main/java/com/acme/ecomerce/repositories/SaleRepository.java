package com.acme.ecomerce.repositories;

import com.acme.ecomerce.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SaleRepository
    extends JpaRepository <Sale, Long> {
}
