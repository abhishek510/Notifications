package com.example.notification.strategy;

import com.example.notification.model.Notification;

public interface NotificationStrategy {
    void sendNotification(Notification notification);
}
