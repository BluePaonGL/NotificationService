package fr.isep.notificationservice.application.port;

import fr.isep.notificationservice.application.DTO.NotificationGroupDto;
import fr.isep.notificationservice.domain.model.NotificationGroup;
import fr.isep.notificationservice.domain.model.UserNotif;

import java.util.List;

public interface NotificationGroupServicePort {
    NotificationGroup saveNotificationGroup(NotificationGroupDto notificationGroupDto);

    List<NotificationGroup> getNotificationGroups();

    List<UserNotif> getUsersByNotificationGroup(String id);

    void addUser(String notificationGroupId, String userId);

    void addNotification(String notificationGroupId, String notificationId);
}
