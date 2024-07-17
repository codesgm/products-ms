package com.products.products_ms.resources;

import com.products.products_ms.entities.User;
import com.products.products_ms.exceptions.UserAlreadyExistsException;
import com.products.products_ms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> createUser (@RequestBody User user){
        try {
            User createUser = userService.createUser(user);
            return ResponseEntity.ok(createUser);
        } catch (UserAlreadyExistsException e){
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }
    }

    @PutMapping
    public ResponseEntity<?> editUser (@RequestBody User user){
        try {
            User editedUser = userService.editUser(user);
            return ResponseEntity.ok(editedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
