package com.vn.learn.java.repository;

import com.vn.learn.java.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author luongld
 * @created 22/03/2023 - 10:41 PM
 * @project learn.java
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);
}
