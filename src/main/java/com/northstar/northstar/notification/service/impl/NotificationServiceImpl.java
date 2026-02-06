package com.northstar.northstar.notification.service.impl;

import com.northstar.northstar.notification.service.dto.NotificationRequest;
import com.northstar.northstar.notification.service.dto.NotificationResponse;
import com.northstar.northstar.notification.service.entity.NotificationEntity;
import com.northstar.northstar.notification.service.mapper.NotificationMapper;
import com.northstar.northstar.notification.service.repository.NotificationRepository;
import com.northstar.northstar.notification.service.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public NotificationServiceImpl(NotificationRepository notificationRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public void createNotification(NotificationRequest request) {
        log.info("Creating notification: {}", request);
        NotificationEntity entity = notificationMapper.createEntityFromRequest(request);
        notificationRepository.save(entity);
    }

    @Override
    public void deleteNotificationByUid(String uid) {
        NotificationEntity entity = notificationRepository.findByUid(uid)
                .orElseThrow(() -> new IllegalArgumentException("Notification not found with uid: " + uid));
        notificationRepository.delete(entity);
    }

    @Override
    public NotificationResponse getNotificationByUid(String uid) {
        return notificationRepository.findByUid(uid)
                .map(notificationMapper::createResponseFromEntity)
                .orElseThrow(() -> new IllegalArgumentException("Notification not found with uid: " + uid));
    }

    @Override
    public List<NotificationResponse> getNotifications(Pageable pageable) {
        return notificationRepository.findAll(pageable).getContent()
                .stream().map(notificationMapper::createResponseFromEntity).toList();
    }

    @Override
    public List<NotificationResponse> getNotificationsByUserId(String userId, Pageable pageable) {
        return notificationRepository.findByUserId(userId, pageable).getContent()
                .stream().map(notificationMapper::createResponseFromEntity).toList();
    }
}
