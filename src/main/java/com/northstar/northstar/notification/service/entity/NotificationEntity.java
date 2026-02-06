package com.northstar.northstar.notification.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ns_notifications")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false, length = 36)
    private String uid;

    @Column(name = "user_uid", nullable = false)
    private String userId;

    private String name;

    private String email;

    private String subject;

    private String body;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @PrePersist
    private void generateUid() {
        if (uid == null) {
            uid = UUID.randomUUID().toString();
        }
    }
}
