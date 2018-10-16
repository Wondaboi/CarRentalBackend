package com.vehicleRental.controller;

import com.vehicleRental.domain.Customer;
import com.vehicleRental.factories.CustomerFactory;
import com.vehicleRental.services.Impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping(path="/all")
    public @ResponseBody
    Set<Customer> getAllCustomer()
    {
        return customerService.findAll();
    }

    @RequestMapping(value="/addCustomer", method = RequestMethod.POST)
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        if(StringUtils.isEmpty(customer.getEmail()) || StringUtils.isEmpty(customer.getName()) || StringUtils.isEmpty(customer.getSurname()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        customerService.create(customer);
        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @RequestMapping(value="/findCustomer/{id}")
    public @ResponseBody ResponseEntity
    findCustomer(@PathVariable("id") Integer id)
    {
        Optional<Customer> customer = customerService.read(id);

        if(!customer.isPresent())
        {
            return new ResponseEntity("No customer found for customer " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @RequestMapping(value="/updateCustomer", method = RequestMethod.PUT)
    public ResponseEntity updateCustomer(@RequestBody Customer customer)
    {
        if(StringUtils.isEmpty(customer.getEmail()) || StringUtils.isEmpty(customer.getName()) || StringUtils.isEmpty(customer.getSurname()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        customerService.update(customer);
        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @RequestMapping(value="/deleteCustomer/{customerID}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable Customer customerID)
    {
        customerService.delete(customerID);
    }


    @CrossOrigin
    @GetMapping(path = "/findByEmail")
    public @ResponseBody Customer availableEmail(String email)
    {
        return customerService.availableEmail(email);
    }


}
