package com.example.userservice.repository;

import com.example.userservice.entity.Subscription;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.Pageable;
import java.util.*;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserId(Long userId);

    @Query("SELECT s.serviceName FROM Subscription s GROUP BY s.serviceName ORDER BY COUNT(s) DESC")
    List<String> findTopSubscriptions(Pageable pageable);
}
