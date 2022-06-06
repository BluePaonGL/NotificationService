package fr.isep.notificationservice.application.port;

import fr.isep.notificationservice.application.DTO.NotificationDto;
import fr.isep.notificationservice.domain.model.Notification;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.NotificationDao;

import java.util.List;

public interface NotificationServicePort {
    Notification saveNotification(NotificationDto notificationDto);

    List<Notification> findAll();

    void deleteNotification(String notificationId);
}