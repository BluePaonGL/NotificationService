package fr.isep.notificationservice.domain.port;

import fr.isep.notificationservice.domain.model.Notification;

import java.util.List;

public interface NotificationRepositoryPort {
    Notification saveNotification(Notification notification);

    List<Notification> findAll();

    void deleteNotification(String notificationId);
}
