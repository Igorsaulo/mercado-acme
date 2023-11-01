package com.acme.ecomerce.controllers;

import com.acme.ecomerce.repositories.UserRepository;
import com.acme.ecomerce.entities.User;
import com.acme.ecomerce.entities.Seller;
import com.acme.ecomerce.entities.Customer;
import com.acme.ecomerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/customer")
    public Customer createCusomer(@RequestBody User user){
        return  userService.createCustomer(user);
    }

    @PostMapping("/seller")
    public Seller createSeller(@RequestBody User user){
        return  userService.createSeller(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.getById(id);
    }
}
