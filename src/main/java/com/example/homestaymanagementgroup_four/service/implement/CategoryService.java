package com.example.homestaymanagementgroup_four.service.implement;

import com.example.homestaymanagementgroup_four.model.Category;
import com.example.homestaymanagementgroup_four.repository.ICategoryRepository;
import com.example.homestaymanagementgroup_four.service.IGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CategoryService implements IGenerateService<Category> {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        categoryRepository.delete(category.get());
    }
}
