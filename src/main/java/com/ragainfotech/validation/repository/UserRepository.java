package com.ragainfotech.validation.repository;

import com.ragainfotech.validation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(int id);
}
