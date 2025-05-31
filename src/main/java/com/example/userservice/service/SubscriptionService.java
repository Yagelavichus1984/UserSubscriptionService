package com.example.userservice.service;

import com.example.userservice.repository.SubscriptionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<String> getTopSubscriptions() {
        return subscriptionRepository.findTopSubscriptions(PageRequest.of(0, 3));
    }
}