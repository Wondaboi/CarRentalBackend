package com.vehicleRental.services.Impl;

import com.vehicleRental.domain.Category;
import com.vehicleRental.repositories.CategoryRepository;
import com.vehicleRental.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> read(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Category id) {
        categoryRepository.delete(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Set<Category> readAll() {
        Iterable<Category> categorys = categoryRepository.findAll();
        Set categorySet = new HashSet();
        for(Category category:categorys)
        {
            categorySet.add(category);
        }
        return categorySet;
    }
}
