package com.acme.ecomerce.services;

import com.acme.ecomerce.entities.User;
import com.acme.ecomerce.entities.Seller;
import com.acme.ecomerce.entities.Customer;
public interface UserServiceContract {
    public User createUser(User user);
    public Seller createSeller(User user);
    public Customer createCustomer(User user);
    public String hashPassword(String password);
}
