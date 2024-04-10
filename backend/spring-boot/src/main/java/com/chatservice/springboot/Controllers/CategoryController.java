package com.chatservice.springboot.Controllers;

import com.chatservice.springboot.Model.Category;
import com.chatservice.springboot.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    // Endpoint to retrieve all categories
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
