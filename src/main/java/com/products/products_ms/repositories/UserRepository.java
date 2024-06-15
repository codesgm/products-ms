package com.products.products_ms.repositories;

import com.products.products_ms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
