package com.vehicleRental.services;

import com.vehicleRental.domain.Category;

import java.util.Optional;
import java.util.Set;

public interface CategoryService {
    Category create(Category category);
    Optional<Category> read(Integer id);
    Category update(Category category);
    void delete(Category id);
    Category findByName(String name);
    Set<Category> readAll();
}
