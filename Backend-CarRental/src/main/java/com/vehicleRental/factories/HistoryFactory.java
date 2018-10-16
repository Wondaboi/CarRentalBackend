package com.vehicleRental.factories;

import com.vehicleRental.domain.History;
import com.vehicleRental.domain.Rent;

import java.util.Map;

public class HistoryFactory
{
    public  static History getHistory(Map<String, Boolean> boolValues, Rent rent)
    {
        History history = new History.Builder()
                .rented(boolValues.get("rented"))
                .outstanding(boolValues.get("outstanding"))
                .rent(rent)
                .build();
        return history;
    }
}
