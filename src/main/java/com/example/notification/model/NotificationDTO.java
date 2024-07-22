package com.example.notification.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class NotificationDTO {
    private String content;
    private NotificationType notificationType;
    private List<String> userId;
    private String title;
    private Type type;
    private Coin product;
}
