package com.example.notification.service;

import com.example.notification.exception.ResourceNotFoundException;
import com.example.notification.factory.NotificationFactory;
import com.example.notification.model.Notification;
import com.example.notification.model.NotificationDTO;
import com.example.notification.model.Status;
import com.example.notification.strategy.NotificationStrategy;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NotService {

    private Map<String, Notification> notificationStorageMap = new HashMap<>();

    public void createNotification(NotificationDTO notificationDTO) {
        for(String userId: notificationDTO.getUserId()) {
            Notification newNotification = Notification.builder()
                    .createdAt(new Date().getTime())
                    .id(UUID.randomUUID().toString())
                    .content(notificationDTO.getContent())
                    .status(Status.CREATED)
                    .type(notificationDTO.getType())
                    .userId(userId)
                    .build();
            notificationStorageMap.put(newNotification.getId(), newNotification);
        }
    }

    public Optional<Notification> findById(String id) {
        return Optional.ofNullable(notificationStorageMap.get(id));
    }

    public void sendNotification(Notification notification) {
        NotificationStrategy strategy = NotificationFactory.getStrategy(notification.getNotificationType());
        strategy.sendNotification(notification);
    }

    public List<Notification> listNotifications(Optional<String> userId, Optional<String> status) {
        return notificationStorageMap.values().stream()
                .filter(notification -> userId.map(id -> id.equals(notification.getUserId())).orElse(true))
                .filter(notification -> status.map(s -> s.equals(notification.getStatus())).orElse(true))
                .collect(Collectors.toList());
    }

    public void deleteNotification(String id) {
        if(notificationStorageMap.containsKey(id)) {
            notificationStorageMap.remove(id);
        } else {
            throw new ResourceNotFoundException("Notification Not found");
        }
    }
}
