package com.example.notification.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Notification {
    private String id;
    private String content;
    private Long createdAt;
    private Status status;
    private NotificationType notificationType;
    private String userId;
    private String title;
    private Type type;
    private Coin product;
}
