package com.vehicleRental.factories;

import com.vehicleRental.domain.Car;
import com.vehicleRental.domain.Category;

import java.util.Map;

public class CarFactory {
    public static Car getCar( Map<String, String> stringValues, int year)
    {
        Car car = new Car.Builder()
                .make(stringValues.get("make"))
                .model(stringValues.get("model"))
                .numberPlate(stringValues.get("numberPlate"))
                .status(stringValues.get("status"))
                .category(stringValues.get("category"))
                .year(year)
                .build();
        return car;
    }
}
