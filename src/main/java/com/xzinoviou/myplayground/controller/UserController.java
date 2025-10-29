package com.xzinoviou.myplayground.controller;

import com.xzinoviou.myplayground.model.dto.UserDto;
import com.xzinoviou.myplayground.model.input.UserCreateInput;
import com.xzinoviou.myplayground.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Xenofon Zinoviou
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody UserCreateInput input) {
        return new ResponseEntity<>(userService.create(input), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserCreateInput input) {
        return ResponseEntity.ok(userService.update(input));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}
