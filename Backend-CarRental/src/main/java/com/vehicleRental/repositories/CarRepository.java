package com.vehicleRental.repositories;

import com.vehicleRental.domain.Car;
import com.vehicleRental.domain.Category;
import org.springframework.data.repository.CrudRepository;


public interface CarRepository extends CrudRepository<Car, Integer>{
    Iterable<Car> findAllById(String category);
    Car findCarsById(Integer id);
}
