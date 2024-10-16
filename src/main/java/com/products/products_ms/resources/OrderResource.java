package com.products.products_ms.resources;

import com.products.products_ms.entities.Order;
import com.products.products_ms.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderResource {
    @Autowired
    private OrderService OrderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = OrderService.findAll();
     return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Order> findById(@PathVariable Long id){
        Order obj = OrderService.findById(id);
        return  ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<?> createOrder (@RequestBody Order Order){
        Order createOrder = OrderService.createOrder(Order);
        return ResponseEntity.ok(createOrder);

    }
}
