package com.vehicleRental.repositories;

import com.vehicleRental.domain.Rent;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent, Integer>
{
    Iterable<Rent> findAllById(Integer id);

}
