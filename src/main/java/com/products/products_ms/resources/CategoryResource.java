package com.products.products_ms.resources;

import com.products.products_ms.entities.Category;
import com.products.products_ms.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {
    @Autowired
    private CategoryService CategoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = CategoryService.findAll();
     return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Category> findById(@PathVariable Long id){
        Category obj = CategoryService.findById(id);
        return  ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<?> createCategory (@RequestBody Category Category){
        Category createCategory = CategoryService.createCategory(Category);
        return ResponseEntity.ok(createCategory);

    }
}
