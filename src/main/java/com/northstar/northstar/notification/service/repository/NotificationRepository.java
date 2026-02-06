package com.northstar.northstar.notification.service.repository;

import com.northstar.northstar.notification.service.entity.NotificationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

    Optional<NotificationEntity> findByUid(String uid);

    Page<NotificationEntity> findByUserId(String userId, Pageable pageable);
}
