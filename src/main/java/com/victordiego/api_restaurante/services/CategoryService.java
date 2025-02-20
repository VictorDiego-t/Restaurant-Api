package com.victordiego.api_restaurante.services;

import com.victordiego.api_restaurante.domain.category.Category;
import com.victordiego.api_restaurante.domain.category.exceptions.CategoryNotFoundException;

import com.victordiego.api_restaurante.domain.category.CategoryDTO;
import com.victordiego.api_restaurante.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category insert(CategoryDTO categoryData) {
        Category newcategory = new Category(categoryData);
        this.repository.save(newcategory);
        return newcategory;
    }

    public List<Category> getAll() {
        return this.repository.findAll();
    }

    public Category update(String id, CategoryDTO categoryData) {


        Category category = this.repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        if(!categoryData.title().isEmpty()) category.setTitle(categoryData.title());
        if(!categoryData.description().isEmpty()) category.setDescription(categoryData.description());
        //if(!categoryData.ownerId().isEmpty()) category.setOwnerId(categoryData.ownerId());

        this.repository.save(category);
        return category;
    }

    public void delete (String id) {

        Category category = this.repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        this.repository.delete(category);
}
}
