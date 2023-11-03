package com.acme.ecomerce.services;

import com.acme.ecomerce.entities.Customer;
import com.acme.ecomerce.exception.user.UserAlreadyExistsException;
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

import java.util.Optional;
import com.acme.ecomerce.exception.user.UserNotFoundException;

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
        user.setUserId(1);
        user.setUserName("test");
        user.setUserEmail("igor@gmail.com");
        user.setUserPassword("123456");

        // Act
        when(userRepository.save(user)).thenReturn(user);
        final User result = userService.createUser(user);

        // Assert
        assertEquals(1, result.getUserId());
        assertEquals("test", result.getUserName());
        assertEquals("igor@gmail.com", result.getUserEmail());
        assertTrue(new BCryptPasswordEncoder().matches("123456", result.getUserPassword()));
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
        user.setUserId(1);
        user.setUserName("test");
        user.setUserEmail("igor@gmail.com");
        user.setUserPassword("123456");

        Seller seller = new Seller();
        seller.setSellerId(1L);

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
        user.setUserId(1);
        user.setUserName("test");
        user.setUserEmail("igor@gmail.com");
        user.setUserPassword("123456");

        Customer customer = new Customer();
        customer.setCustomerId(1);

        // Act
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        final Customer result = userService.createCustomer(user);

        // Assert
        assertEquals(customer, result);
    }

    @Test
    public void testGetUserByEmail() {
        // Arrange
        UserService userService = new UserService(
                userRepository,
                sellerRepository,
                customerRepository
        );
        User user = new User();
        user.setUserId(1);
        user.setUserName("test");
        user.setUserEmail("john.doe@gmail.com");
        user.setUserPassword("123456");

        // Act
        when(userRepository.findByUserEmail("john.doe@gmail.com")).thenReturn(java.util.Optional.of(user));
        final Optional<User> result = userService.getUserByEmail("john.doe@gmail.com");

        // Assert
        assertEquals(user, result.get());
    }

    @Test
    public void testCreateUserException() {
        // Arrange
        UserService userService = new UserService(
                userRepository,
                sellerRepository,
                customerRepository
        );
        User user = new User();
        user.setUserId(1);
        user.setUserName("test");
        user.setUserEmail("john.doe@gmail.com");
        user.setUserPassword("123456");

        when(userRepository.findByUserEmail("john.doe@gmail.com")).thenReturn(Optional.of(user));

        // Act e Assert
        assertThrows(UserAlreadyExistsException.class, () -> userService.createUser(user));
    }


    @Test
    public void testGetUserByEmailException() {
        // Arrange
        UserService userService = new UserService(
                userRepository,
                sellerRepository,
                customerRepository
        );
        User user = new User();
        user.setUserId(1);
        user.setUserName("test");
        user.setUserEmail("john.doe@gmail.com");
        user.setUserPassword("123456");

        // Act
        when(userRepository.findByUserEmail("john.doe@gmail.com")).thenReturn(java.util.Optional.of(user));
        final UserNotFoundException result = assertThrows(UserNotFoundException.class,
                () -> userService.getUserByEmail("jose@gmail.com"));

        // Assert
        assertEquals("User not found", result.getMessage());
    }
}
