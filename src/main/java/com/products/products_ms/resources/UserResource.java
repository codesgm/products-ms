package com.products.products_ms.resources;

import com.products.products_ms.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
     User u = new User(1L,"John","LrSjM@example.com","123456789","123456");
     return ResponseEntity.ok().body(u);
    }

}
