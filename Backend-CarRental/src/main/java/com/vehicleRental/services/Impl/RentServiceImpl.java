package com.vehicleRental.services.Impl;


import com.vehicleRental.domain.Rent;
import com.vehicleRental.factories.RentFactory;
import com.vehicleRental.repositories.RentRepository;
import com.vehicleRental.repositories.RentRepository;
import com.vehicleRental.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * Created by Long on 9/14/2018.
 */
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class RentServiceImpl implements RentService
{
    @Autowired
    private RentRepository rentRepository;


    @Override
    public Rent create(Rent rent) {

        return rentRepository.save(rent);
    }

    @Override
    public Optional<Rent> read(Integer id) {
        return rentRepository.findById(id);
    }

    @Override
    public Rent update(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public void delete(Rent id) {
        rentRepository.delete(id);
    }

    @Override
    public Set<Rent> readAll() {
        Iterable<Rent> rents = rentRepository.findAll();
        Set rentSet = new HashSet();
        for(Rent rent:rents)
        {
            rentSet.add(rent);
        }
        return rentSet;
    }

    @Override
    public Iterable<Rent> findAllById(Integer id) {
        return rentRepository.findAllById(id);
    }
}
