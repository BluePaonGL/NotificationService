package fr.isep.notificationservice.infrastructure.adapter_repository_db.adapter;

import fr.isep.notificationservice.domain.model.NotificationGroup;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.EventNotifDao;
import fr.isep.notificationservice.domain.model.EventNotif;
import fr.isep.notificationservice.domain.port.EventNotifRepositoryPort;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.NotificationGroupDao;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.repository.EventNotifRepository;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.repository.NotificationGroupRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EventNotifRepositoryAdapter implements EventNotifRepositoryPort {
    private final ModelMapper modelMapper;
    private EventNotifRepository eventNotifRepository;
    private NotificationGroupRepository notificationGroupRepository;

    @Override
    public EventNotif saveEventNotification(EventNotif eventNotif) {
        EventNotifDao eventNotifDao = modelMapper.map(eventNotif, EventNotifDao.class);
        NotificationGroupDao notificationGroup = new NotificationGroupDao();
        this.notificationGroupRepository.save(notificationGroup);
        eventNotifDao.setNotificationGroupDao(notificationGroup);
        return modelMapper.map(this.eventNotifRepository.save(eventNotifDao), EventNotif.class);
    }
}
