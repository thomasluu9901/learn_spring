package com.vn.learn.java.controller;

import com.vn.learn.java.entity.UserEntity;
import com.vn.learn.java.dto.SortUpdateDTO;
import com.vn.learn.java.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author thomas_luu
 * @created 20/04/2023 - 12:44 PM
 * @project learn_spring
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/all")
    public List<UserEntity> hello() {
        return userService.findAll();
    }
    @PutMapping("/update")
    public void update(@RequestBody SortUpdateDTO dto) {
        userService.update(dto);
    }
}
