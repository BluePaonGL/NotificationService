package fr.isep.notificationservice.application.port;

import fr.isep.notificationservice.application.DTO.NotificationGroupDto;
import fr.isep.notificationservice.domain.model.NotificationGroup;

import java.util.List;

public interface NotificationGroupPort {
    NotificationGroup saveNotificationGroup(NotificationGroupDto notificationGroupDto);

    List<NotificationGroup> getNotificationGroups();
}
