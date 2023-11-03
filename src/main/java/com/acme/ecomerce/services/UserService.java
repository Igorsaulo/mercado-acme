package com.acme.ecomerce.services;

import com.acme.ecomerce.entities.Customer;
import com.acme.ecomerce.exception.user.UserAlreadyExistsException;
import com.acme.ecomerce.exception.user.UserNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.acme.ecomerce.entities.User;
import com.acme.ecomerce.entities.Seller;
import com.acme.ecomerce.repositories.UserRepository;
import com.acme.ecomerce.repositories.SellerRepository;
import com.acme.ecomerce.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceContract {
    private final UserRepository userRepository;
    private final SellerRepository sellerRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public UserService(
            UserRepository userRepository,
            SellerRepository sellerRepository,
            CustomerRepository customerRepository
    ) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public User createUser(User user) {
        User userExists = userRepository
                .findByUserEmail(user.getUserEmail()).orElse(null);
        if (userExists != null) {
            throw new UserAlreadyExistsException("User already exists");
        }
        user.setUserPassword(hashPassword(user.getUserPassword()));
        return userRepository.save(user);
    }

    @Override
    public Seller createSeller(User user) {
        Seller seller = new Seller();
        User newUser = createUser(user);
        seller.setUser(newUser);
        return sellerRepository.save(seller);
    }


    @Override
    public Customer createCustomer(User user) {
        new Customer();
        User newUser = createUser(user);
        Customer customer = new Customer();
        customer.setUser(newUser);
        return customerRepository.save(customer);
    }

    @Override
    public String hashPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByUserEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found")));
    }
}
