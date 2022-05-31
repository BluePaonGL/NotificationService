package fr.isep.notificationservice.domain.port;

import fr.isep.notificationservice.domain.model.Notification;

public interface NotificationRepositoryPort {
    Notification saveNotification(Notification notification);
}
