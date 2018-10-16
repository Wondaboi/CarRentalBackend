package com.vehicleRental.controller;

import com.vehicleRental.domain.Category;
import com.vehicleRental.factories.CategoryFactory;
import com.vehicleRental.services.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;


@Controller
@RequestMapping(path = "/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping(path="/all")
    public @ResponseBody
    Set<Category> getAllCategory()
    {
        return categoryService.readAll();
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity addCategory(@RequestBody Category category){
        if(StringUtils.isEmpty(category.getName()) || StringUtils.isEmpty(category.getPrice()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        categoryService.create(category);
        return new ResponseEntity(category, HttpStatus.OK);
    }

    @RequestMapping(value="/find/{id}")
    public @ResponseBody ResponseEntity
    findCategory(@PathVariable("id") Integer id)
    {
        Optional<Category> category = categoryService.read(id);

        if(!category.isPresent())
        {
            return new ResponseEntity("No category found for category " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(category, HttpStatus.OK);
    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public ResponseEntity updateCategory(@RequestBody Category category)
    {
        if(StringUtils.isEmpty(category.getName()) || StringUtils.isEmpty(category.getPrice()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        categoryService.update(category);
        return new ResponseEntity(category, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{categoryID}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable Category categoryID)
    {
        categoryService.delete(categoryID);
    }

}
