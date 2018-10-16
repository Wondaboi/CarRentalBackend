package com.vehicleRental.repositories;

import com.vehicleRental.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer>{
    Category findByName(String name);
}
