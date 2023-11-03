package com.acme.ecomerce.repositories;

import com.acme.ecomerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, Long> {
    Optional<User> findByUserEmail(String email);
}