package fr.isep.notificationservice.domain.port;

import fr.isep.notificationservice.domain.model.Notification;

import java.util.List;

public interface NotificationRepositoryPort {
    Notification saveNotification(Notification notification);

    void addNotification(String notificationId, String notificationGroupId);

    List<Notification> findAll();
}
