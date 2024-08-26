package com.prernagaikwad.springboot.LeaveSystemdemo.Rest;

import com.prernagaikwad.springboot.LeaveSystemdemo.Service.NotificationServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationServiceI notificationService;

    @GetMapping("/test")
    public String testNotifications() {
        notificationService.sendDailyNotifications();
        return "Notification service tested successfully";
    }
}