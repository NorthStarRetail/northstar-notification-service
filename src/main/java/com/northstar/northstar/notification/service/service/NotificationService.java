package com.northstar.northstar.notification.service.service;

import com.northstar.northstar.notification.service.dto.NotificationRequest;
import com.northstar.northstar.notification.service.dto.NotificationResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {

    void createNotification(NotificationRequest request);

    void deleteNotificationByUid(String uid);

    NotificationResponse getNotificationByUid(String uid);

    List<NotificationResponse> getNotifications(Pageable pageable);

    List<NotificationResponse> getNotificationsByUserId(String userId, Pageable pageable);
}
