package com.example.userservice.controller;

import com.example.userservice.entity.Subscription;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/subscriptions")
    public ResponseEntity<Subscription> addSubscription(@PathVariable Long id, @RequestBody Subscription sub) {
        return ResponseEntity.ok(userService.addSubscription(id, sub));
    }

    @GetMapping("/{id}/subscriptions")
    public ResponseEntity<List<Subscription>> getSubscriptions(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getSubscriptions(id));
    }

    @DeleteMapping("/{id}/subscriptions/{subId}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long id, @PathVariable Long subId) {
        userService.deleteSubscription(id, subId);
        return ResponseEntity.noContent().build();
    }
}
