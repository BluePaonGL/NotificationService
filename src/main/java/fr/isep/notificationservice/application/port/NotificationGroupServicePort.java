package fr.isep.notificationservice.application.port;

import fr.isep.notificationservice.application.DTO.NotificationGroupDto;
import fr.isep.notificationservice.domain.model.NotificationGroup;
import fr.isep.notificationservice.domain.model.User;

import java.util.List;

public interface NotificationGroupServicePort {
    NotificationGroup saveNotificationGroup(NotificationGroupDto notificationGroupDto);

    List<NotificationGroup> getNotificationGroups();

    List<User> getUsersByNotificationGroup(String id);

    void addUser(String notificationGroupId, String userId);
}
