package com.vehicleRental.services;

import com.vehicleRental.domain.Car;
import com.vehicleRental.domain.Category;

import java.util.Optional;
import java.util.Set;

public interface CarService {
    Car create(Car car);
    Optional<Car> read(Integer id);
    Car update(Car car);
    void delete(Car id);

    //function to read all cars in the database and print to table
    Set<Car> readAll();

    //function to read all cars based on the category
    Iterable<Car> findAllById(String category);

    Iterable<Car> findAllById1(String status);

}
