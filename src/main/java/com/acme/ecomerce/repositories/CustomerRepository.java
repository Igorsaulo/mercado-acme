package com.acme.ecomerce.repositories;

import com.acme.ecomerce.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository
    extends JpaRepository <Customer, Long> {
}
