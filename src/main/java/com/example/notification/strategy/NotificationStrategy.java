package com.example.notification.strategy;

import com.example.notification.model.Notification;
import com.example.notification.model.NotificationDTO;

public interface NotificationStrategy {
    void sendNotification(Notification notification);
}
