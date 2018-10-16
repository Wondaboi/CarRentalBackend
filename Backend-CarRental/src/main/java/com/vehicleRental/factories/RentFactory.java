package com.vehicleRental.factories;

import com.vehicleRental.domain.Rent;

import java.math.BigDecimal;

public class RentFactory
{
    public static Rent getRent(String model,String category,String rentDate, String customerName, BigDecimal totalPrice, int rentalDays,String status)
    {
        Rent rent = new Rent.Builder()
                .model(model)
                .category(category)
                .rentDate(rentDate)
                .customerName(customerName)
                .rentalDays(rentalDays)
                .totalPrice(totalPrice)
                .status(status)
                .build();
        return  rent;
    }
}
