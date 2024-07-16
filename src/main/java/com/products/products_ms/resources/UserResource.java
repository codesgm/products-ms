package com.products.products_ms.resources;

import com.products.products_ms.entities.User;
import com.products.products_ms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();
     return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <User> findById(@PathVariable Long id){
        User obj = userService.findById(id);
        return  ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User user){
        User createUser = userService.createUser(user);
        return ResponseEntity.ok(createUser);
    }
}
