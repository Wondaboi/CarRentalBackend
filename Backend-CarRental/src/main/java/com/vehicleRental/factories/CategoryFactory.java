package com.vehicleRental.factories;

import com.vehicleRental.domain.Category;

public class CategoryFactory {
    public static Category getCategory(String name, double price)
    {
        Category category = new Category.Builder()
                .name(name)
                .price(price)
                .build();
        return category;
    }
}
