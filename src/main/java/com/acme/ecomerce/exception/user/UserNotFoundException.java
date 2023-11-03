package com.acme.ecomerce.exception.user;

public class UserNotFoundException extends RuntimeException {
   public UserNotFoundException (String message) {
      super(message);
   }
}
