package com.vehicleRental.services.Impl;

import com.vehicleRental.domain.Car;
import com.vehicleRental.domain.Category;
import com.vehicleRental.repositories.CarRepository;
import com.vehicleRental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> read(Integer id) {
        return carRepository.findById(id);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(Car id) {
        carRepository.delete(id);
    }

    //function to read all cars in the database and prInteger to table
    @Override
    public Set<Car> readAll() {
        Iterable<Car> cars = carRepository.findAll();
        Set carSet = new HashSet();
        for(Car car:cars)
        {
            carSet.add(car);
        }
        return carSet;
    }


    //function to read all cars based on the category
    @Override
    public Iterable<Car> findAllById(String category) {

        return carRepository.findAllById(category);
    }
    //function to read all cars based on the status
    @Override
    public Iterable<Car> findAllById1(String status) {

        return carRepository.findAllById(status);
    }
}