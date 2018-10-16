package com.vehicleRental.repositories;

import com.vehicleRental.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    Customer findByEmail(String email);
}
