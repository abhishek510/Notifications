package com.example.notification.controller;

import com.example.notification.model.Notification;
import com.example.notification.service.NotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotService notificationService;

    @PostMapping("/create")
    public void createNotification(@RequestBody Notification notification) {
        notificationService.createNotification(notification);
    }

    @PostMapping("{id}/send")
    public void sendNotification(@PathVariable String id) throws Exception {
        Optional<Notification> notification = notificationService.findById(id);
        if (notification.isPresent()) {
            notificationService.sendNotification(notification.get());
        } else {
            throw new Exception("Invalid Notification Id");
        }
    }

    @GetMapping("/list")
    public List<Notification> getNotifications(@RequestParam Optional<String> userId, @RequestParam Optional<String> status) {
        return notificationService.listNotifications(userId, status);
    }
}
