package com.vehicleRental.services;

import com.vehicleRental.domain.Rent;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

public interface RentService
{
    Rent create(Rent rent);
    Optional<Rent> read(Integer id);
    Rent update(Rent rent);
    void delete(Rent id);
    Set<Rent> readAll();
    Iterable<Rent> findAllById(Integer id);
}
