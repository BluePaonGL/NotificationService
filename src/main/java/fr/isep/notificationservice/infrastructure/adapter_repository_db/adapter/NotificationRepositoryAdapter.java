package fr.isep.notificationservice.infrastructure.adapter_repository_db.adapter;

import fr.isep.notificationservice.domain.model.Notification;
import fr.isep.notificationservice.domain.port.NotificationRepositoryPort;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.NotificationDao;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.repository.NotificationGroupRepository;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.repository.NotificationRepository;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.repository.UserNotifRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class NotificationRepositoryAdapter implements NotificationRepositoryPort {
    private final ModelMapper modelMapper;
    private NotificationRepository notificationRepository;
    private NotificationGroupRepository notificationGroupRepository;
    private UserNotifRepository userNotifRepository;

    @Override
    public Notification saveNotification(Notification notification) {
        NotificationDao notificationDao = modelMapper.map(notification, NotificationDao.class);
        return modelMapper.map(this.notificationRepository.save(notificationDao), Notification.class);
    }

    @Override
    public List<Notification> findAll() {
        List<NotificationDao> notificationDao = this.notificationRepository.findAll();
        return notificationDao.stream().map(notification -> modelMapper.map(notification, Notification.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteNotification(String notificationId) {
        this.notificationRepository.delete(notificationRepository.findByNotificationId(notificationId));
    }
}