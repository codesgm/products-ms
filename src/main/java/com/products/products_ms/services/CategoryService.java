package com.products.products_ms.services;

import com.products.products_ms.entities.Category;
import com.products.products_ms.entities.User;
import com.products.products_ms.exceptions.UserAlreadyExistsException;
import com.products.products_ms.repositories.CategoryRepository;
import com.products.products_ms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }

    public Category createCategory (Category category){

        return categoryRepository.save(category);
    }

}
