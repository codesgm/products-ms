package com.products.products_ms.config;

import com.products.products_ms.entities.Category;
import com.products.products_ms.entities.Order;
import com.products.products_ms.entities.User;
import com.products.products_ms.entities.enums.OrderStatus;
import com.products.products_ms.repositories.CategoryRepository;
import com.products.products_ms.repositories.OrderRepository;
import com.products.products_ms.repositories.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown","051.916.110-63", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "194.605.660-06", "alex@gmail.com", "977777777", "123456");

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.DELIVERED);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2,o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
    }
}
