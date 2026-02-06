package com.northstar.northstar.notification.service.mapper;

import com.northstar.northstar.notification.service.dto.NotificationRequest;
import com.northstar.northstar.notification.service.dto.NotificationResponse;
import com.northstar.northstar.notification.service.entity.NotificationEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-06T16:54:10+0000",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Azul Systems, Inc.)"
)
@Component
public class NotificationMapperImpl implements NotificationMapper {

    @Override
    public NotificationEntity createEntityFromRequest(NotificationRequest request) {
        if ( request == null ) {
            return null;
        }

        NotificationEntity.NotificationEntityBuilder notificationEntity = NotificationEntity.builder();

        notificationEntity.userId( request.getUserId() );
        notificationEntity.name( request.getName() );
        notificationEntity.email( request.getEmail() );
        notificationEntity.subject( request.getSubject() );
        notificationEntity.body( request.getBody() );

        return notificationEntity.build();
    }

    @Override
    public NotificationResponse createResponseFromEntity(NotificationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        NotificationResponse.NotificationResponseBuilder notificationResponse = NotificationResponse.builder();

        notificationResponse.id( entity.getId() );
        notificationResponse.uid( entity.getUid() );
        notificationResponse.name( entity.getName() );
        notificationResponse.email( entity.getEmail() );
        notificationResponse.subject( entity.getSubject() );
        notificationResponse.body( entity.getBody() );
        notificationResponse.createdAt( entity.getCreatedAt() );

        notificationResponse.userId( entity.getUserId() != null ? String.valueOf(entity.getUserId()) : null );

        return notificationResponse.build();
    }
}
