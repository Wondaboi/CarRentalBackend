package com.vehicleRental.controller;

import com.vehicleRental.domain.Rent;
import com.vehicleRental.factories.RentFactory;
import com.vehicleRental.services.Impl.CarServiceImpl;
import com.vehicleRental.services.Impl.RentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping(path = "/rent")
public class RentController
{
    @Autowired
    private RentServiceImpl rentService;

    @GetMapping(path="/findAll")
    public @ResponseBody
    Set<Rent> getAllRent()
    {
        return rentService.readAll();
    }

    @RequestMapping(value="/rentCar", method = RequestMethod.POST)
    public ResponseEntity addRent(@RequestBody Rent rent){
        if(StringUtils.isEmpty(rent.getModel()) || StringUtils.isEmpty(rent.getCustomerName()) || StringUtils.isEmpty(rent.getRentDate()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        rentService.create(rent);
        return new ResponseEntity(rent, HttpStatus.OK);
    }

    @RequestMapping(value="/find/{id}")
    public @ResponseBody ResponseEntity
    findRent(@PathVariable("id") Integer id)
    {
        Optional<Rent> rent = rentService.read(id);

        if(!rent.isPresent())
        {
            return new ResponseEntity("No rent found for rent " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(rent, HttpStatus.OK);
    }

    @RequestMapping(value="/updateRent", method = RequestMethod.PUT)
    public ResponseEntity updateRent(@RequestBody Rent rent)
    {
        if(StringUtils.isEmpty(rent.getModel()) || StringUtils.isEmpty(rent.getCustomerName()) || StringUtils.isEmpty(rent.getRentDate()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        rentService.update(rent);
        return new ResponseEntity(rent, HttpStatus.OK);
    }

    @RequestMapping(value="/deleteRent/{rentID}", method = RequestMethod.DELETE)
    public void deleteRent(@PathVariable Rent rentID)
    {
        rentService.delete(rentID);
    }


}
