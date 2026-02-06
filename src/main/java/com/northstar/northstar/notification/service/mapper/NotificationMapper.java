package com.northstar.northstar.notification.service.mapper;

import com.northstar.northstar.notification.service.dto.NotificationRequest;
import com.northstar.northstar.notification.service.dto.NotificationResponse;
import com.northstar.northstar.notification.service.entity.NotificationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationEntity createEntityFromRequest(NotificationRequest request);

    @Mapping(target = "userId", expression = "java(entity.getUserId() != null ? String.valueOf(entity.getUserId()) : null)")
    NotificationResponse createResponseFromEntity(NotificationEntity entity);
}
