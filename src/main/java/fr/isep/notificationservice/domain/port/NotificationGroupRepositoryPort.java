package fr.isep.notificationservice.domain.port;

import fr.isep.notificationservice.domain.model.NotificationGroup;
import fr.isep.notificationservice.domain.model.UserNotif;

import java.util.List;

public interface NotificationGroupRepositoryPort {
    NotificationGroup save(NotificationGroup notification);

    List<NotificationGroup> findAll();

    List<UserNotif> getUsersByNotificationGroup(String id);

    NotificationGroup getNotificationGroupById(String id);

    void addUserToNotificationGroup(String notificationGroupId, String userId);
}
