package com.vehicleRental.controller;

import com.vehicleRental.domain.Car;
import com.vehicleRental.services.Impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path = "/car")
public class CarController {
    @Autowired
    private CarServiceImpl carService;

    @GetMapping(path="/all")
    public @ResponseBody
    Set<Car> getAllCar()
    {
        return carService.readAll();
    }

    @RequestMapping(value="/addCar", method = RequestMethod.POST)
    public ResponseEntity addCar(@RequestBody Car car){
        if(StringUtils.isEmpty(car.getMake()) || StringUtils.isEmpty(car.getModel()) || StringUtils.isEmpty(car.getYear()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        carService.create(car);
        return new ResponseEntity(car, HttpStatus.OK);
    }

    @RequestMapping(value="/find/{id}")
    public @ResponseBody ResponseEntity
    findCar(@PathVariable("id") Integer id)
    {
        Optional<Car> car = carService.read(id);

        if(!car.isPresent())
        {
            return new ResponseEntity("No car found for car " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(car, HttpStatus.OK);
    }

    @RequestMapping(value="/updateCar", method = RequestMethod.PUT)
    public ResponseEntity updateCar(@RequestBody Car car)
    {
        if(StringUtils.isEmpty(car.getModel()) || StringUtils.isEmpty(car.getMake()) || StringUtils.isEmpty(car.getYear()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        carService.update(car);
        return new ResponseEntity(car, HttpStatus.OK);
    }

    @RequestMapping(value="/deleteCar/{carID}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable Car carID)
    {
        carService.delete(carID);
    }

    @GetMapping(path = "/carCategory")
    public @ResponseBody Iterable<Car> findAllById(String category) {return carService.findAllById(category);}

    @GetMapping(path = "/carAvailable")
    public @ResponseBody Iterable<Car> findAllById1(String status) {return carService.findAllById(status);}


}
