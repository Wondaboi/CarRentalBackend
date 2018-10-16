package com.vehicleRental.services;

import com.vehicleRental.domain.Customer;

import java.util.Optional;
import java.util.Set;

public interface CustomerService {
    Customer create(Customer customer);
    Optional<Customer> read(Integer id);
    Customer update(Customer customer);
    void delete(Customer id);
    Set<Customer> findAll();
    Customer availableEmail(String email);
}
