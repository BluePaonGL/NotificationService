package fr.isep.notificationservice.application.port;

import fr.isep.notificationservice.application.DTO.NotificationDto;
import fr.isep.notificationservice.domain.model.Notification;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.NotificationDao;

public interface NotificationServicePort {
    Notification saveNotification(NotificationDto notificationDto);
}
