package fr.isep.notificationservice.infrastructure.adapter_repository_db.adapter;

import fr.isep.notificationservice.domain.model.Notification;
import fr.isep.notificationservice.domain.port.NotificationRepositoryPort;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.NotificationDao;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NotificationRepositoryAdapter implements NotificationRepositoryPort {
    private final ModelMapper modelMapper;
    private NotificationRepository notificationRepository;

    @Override
    public Notification saveNotification(Notification notification) {
        NotificationDao notificationDao = modelMapper.map(notification, NotificationDao.class);
        return modelMapper.map(this.notificationRepository.save(notificationDao), Notification.class);
    }
}
