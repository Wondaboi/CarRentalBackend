package com.vehicleRental.services.Impl;

import com.vehicleRental.domain.Customer;
import com.vehicleRental.repositories.CustomerRepository;
import com.vehicleRental.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> read(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Customer id) {
        customerRepository.delete(id);
    }

    @Override
    public Set<Customer> findAll() {
        Iterable<Customer> customers = customerRepository.findAll();
        Set customerSet = new HashSet();
        for(Customer customer:customers)
        {
            customerSet.add(customer);
        }
        return customerSet;
    }

    @Override
    public Customer availableEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
