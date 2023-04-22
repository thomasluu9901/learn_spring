package com.vn.learn.java.repository;

import com.vn.learn.java.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author luongld
 * @created 22/03/2023 - 10:41 PM
 * @project learn.java
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmail(String email);
    @Query(value = "select u.order_column from  user_entity u order by u.order_column asc limit 1",nativeQuery = true)
    String getRankTopAsc();
    @Query(value = "select * from  user_entity u order by u.order_column desc",nativeQuery = true)
    List<UserEntity> findAllOrderBy();
}
