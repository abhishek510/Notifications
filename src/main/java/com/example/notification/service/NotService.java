package com.example.notification.service;

import com.example.notification.factory.NotificationFactory;
import com.example.notification.model.Notification;
import com.example.notification.strategy.NotificationStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NotService {

    private Map<String, Notification> notificationStorageMap = new HashMap<>();

    public void createNotification(Notification notification) {
        Notification newNotification = Notification.builder()
                .createdAt(new Date().getTime())
                .id(notification.getId())
                .content(notification.getContent())
                .status(notification.getStatus())
                .type(notification.getType())
                .user(notification.getUser())
                .build();
        notificationStorageMap.put(notification.getId(), newNotification);
    }

    public Optional<Notification> findById(String id) {
        return Optional.ofNullable(notificationStorageMap.get(id));
    }

    public void sendNotification(Notification notification) {
        NotificationStrategy strategy = NotificationFactory.getStrategy(notification.getType());
        strategy.sendNotification(notification);
    }

    public List<Notification> listNotifications(String userId, String status) {
        return notificationStorageMap.values().stream()
                .filter(notification -> userId.map(id -> notification.getUser().stream().filter()))
    }
}
