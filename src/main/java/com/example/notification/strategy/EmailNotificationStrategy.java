package com.example.notification.strategy;

import com.example.notification.model.Notification;
import com.example.notification.model.Status;

public class EmailNotificationStrategy implements NotificationStrategy{

    @Override
    public void sendNotification(Notification notification) {
        notification.setStatus(Status.SENT);
    }
}
