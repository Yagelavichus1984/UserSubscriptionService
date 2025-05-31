package com.example.userservice.service;

import com.example.userservice.entity.Subscription;
import com.example.userservice.entity.User;
import com.example.userservice.repository.SubscriptionRepository;
import com.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;

    public UserService(UserRepository userRepository, SubscriptionRepository subscriptionRepository) {
        this.userRepository = userRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUser(id);
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Subscription addSubscription(Long userId, Subscription sub) {
        User user = getUser(userId);
        sub.setUser(user);
        return subscriptionRepository.save(sub);
    }

    public List<Subscription> getSubscriptions(Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }

    public void deleteSubscription(Long userId, Long subId) {
        subscriptionRepository.deleteById(subId);
    }
}
