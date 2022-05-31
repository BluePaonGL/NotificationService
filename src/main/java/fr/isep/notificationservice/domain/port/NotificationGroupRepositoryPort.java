package fr.isep.notificationservice.domain.port;

import fr.isep.notificationservice.domain.model.NotificationGroup;

import java.util.List;

public interface NotificationGroupRepositoryPort {
    NotificationGroup save(NotificationGroup notification);

    List<NotificationGroup> findAll();
}
