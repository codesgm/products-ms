package com.products.products_ms.services;

import com.products.products_ms.entities.Category;
import com.products.products_ms.entities.Order;
import com.products.products_ms.repositories.CategoryRepository;
import com.products.products_ms.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }

    public Order createOrder (Order order){

        return orderRepository.save(order);
    }

}
