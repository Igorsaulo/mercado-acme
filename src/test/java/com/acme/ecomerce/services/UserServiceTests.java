package com.acme.ecomerce.services;

import com.acme.ecomerce.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.acme.ecomerce.entities.User;
import com.acme.ecomerce.entities.Seller;
import com.acme.ecomerce.repositories.UserRepository;
import com.acme.ecomerce.repositories.SellerRepository;
import com.acme.ecomerce.repositories.CustomerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceTests {
    @Mock
    private UserRepository userRepository;

    @Mock
    private SellerRepository sellerRepository;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser() {
        // Arrange
        UserService userService = new UserService(
                userRepository,
                sellerRepository,
                customerRepository
        );
        User user = new User();
        user.setUser_id(1);
        user.setUser_name("test");
        user.setUser_email("igor@gmail.com");
        user.setUser_password("123456");

        // Act
        when(userRepository.save(user)).thenReturn(user);
        final User result = userService.createUser(user);

        // Assert
        assertEquals(1, result.getUser_id());
        assertEquals("test", result.getUser_name());
        assertEquals("igor@gmail.com", result.getUser_email());
        assertTrue(new BCryptPasswordEncoder().matches("123456", result.getUser_password()));
    }

    @Test
    public void testCreateSeller() {
        // Arrange
        UserService userService = new UserService(
                userRepository,
                sellerRepository,
                customerRepository
        );
        User user = new User();
        user.setUser_id(1);
        user.setUser_name("test");
        user.setUser_email("igor@gmail.com");
        user.setUser_password("123456");

        Seller seller = new Seller();
        seller.setSeller_id(1);

        // Act
        when(sellerRepository.save(any(Seller.class))).thenReturn(seller);
        final Seller result = userService.createSeller(user);

        // Assert
        assertEquals(seller, result);
    }


    @Test
    public void testCreateCustomer() {
        // Arrange
        UserService userService = new UserService(
                userRepository,
                sellerRepository,
                customerRepository
        );
        User user = new User();
        user.setUser_id(1);
        user.setUser_name("test");
        user.setUser_email("igor@gmail.com");
        user.setUser_password("123456");

        Customer customer = new Customer();
        customer.setCustomer_id(1);

        // Act
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        final Customer result = userService.createCustomer(user);

        // Assert
        assertEquals(customer, result);
    }
}
