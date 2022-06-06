package fr.isep.notificationservice.domain.service;


import fr.isep.notificationservice.application.DTO.NotificationDto;
import fr.isep.notificationservice.application.port.NotificationServicePort;
import fr.isep.notificationservice.domain.model.Notification;
import fr.isep.notificationservice.domain.port.NotificationRepositoryPort;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.NotificationDao;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService implements NotificationServicePort{
    private final NotificationRepositoryPort notificationRepositoryPort;
    private final ModelMapper modelMapper;

    @Override
    public Notification saveNotification(NotificationDto notificationDto) {
        Notification notification = modelMapper.map(notificationDto, Notification.class);
        return this.notificationRepositoryPort.saveNotification(notification);
    }

    @Override
    public List<Notification> findAll() {
        List<Notification> result = this.notificationRepositoryPort.findAll();
        return result;
    }

    @Override
    public void deleteNotification(String notificationId) {
        this.notificationRepositoryPort.deleteNotification(notificationId);
    }
}