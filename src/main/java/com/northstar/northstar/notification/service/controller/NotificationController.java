package com.northstar.northstar.notification.service.controller;

import com.northstar.northstar.notification.service.dto.NotificationRequest;
import com.northstar.northstar.notification.service.dto.NotificationResponse;
import com.northstar.northstar.notification.service.service.NotificationService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/notifications")
@Tag(name = "Notifications", description = "Notification Management API")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Operation(summary = "Create notification")
    @PostMapping
    @Hidden
    public ResponseEntity<Void> createNotification(@Valid @RequestBody NotificationRequest request) {
        notificationService.createNotification(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get notification by ID")
    @GetMapping("/{id}")
    public ResponseEntity<NotificationResponse> getNotificationById(@PathVariable String id) {
        return ResponseEntity.ok(notificationService.getNotificationByUid(id));
    }

    @Operation(summary = "Delete notification")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable String id) {
        notificationService.deleteNotificationByUid(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get notifications")
    @GetMapping
    public ResponseEntity<List<NotificationResponse>> getNotifications(
            @Parameter(description = "Page number (default: 0)") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size (default: 10)") @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(notificationService.getNotifications(PageRequest.of(page, size)));
    }

    @Operation(summary = "Get notifications for a user")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationResponse>> getNotificationsByUserId(
            @PathVariable String userId,
            @Parameter(description = "Page number (default: 0)") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size (default: 10)") @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(notificationService.getNotificationsByUserId(userId, PageRequest.of(page, size)));
    }
}
