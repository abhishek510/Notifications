package com.example.notification.factory;

import com.example.notification.model.Notification;
import com.example.notification.model.NotificationType;
import com.example.notification.strategy.EmailNotificationStrategy;
import com.example.notification.strategy.NotificationStrategy;

public class NotificationFactory {
    public static NotificationStrategy getStrategy(NotificationType type) {
        if(type.equals(NotificationType.EMAIL)) {
            return new EmailNotificationStrategy();
        }
        throw new IllegalArgumentException("Unknown type");
    }
}
