package fr.isep.notificationservice.infrastructure.adapter_repository_db.adapter;

import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.EventNotifDao;
import fr.isep.notificationservice.domain.model.EventNotif;
import fr.isep.notificationservice.domain.port.EventNotifRepositoryPort;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.NotificationDao;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.NotificationGroupDao;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.repository.EventNotifRepository;
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
public class EventNotifRepositoryAdapter implements EventNotifRepositoryPort {
    private final ModelMapper modelMapper;
    private EventNotifRepository eventNotifRepository;
    private UserNotifRepository userNotifRepository;
    private NotificationRepository notificationRepository;
    private NotificationGroupRepository notificationGroupRepository;

    @Override
    public EventNotif saveEventNotification(EventNotif eventNotif) {
        EventNotifDao eventNotifDao = modelMapper.map(eventNotif, EventNotifDao.class);
        NotificationGroupDao notificationGroup = new NotificationGroupDao();
        this.notificationGroupRepository.save(notificationGroup);
        eventNotifDao.setNotificationGroupDao(notificationGroup);
        return modelMapper.map(this.eventNotifRepository.save(eventNotifDao), EventNotif.class);
    }

    @Override
    public List<EventNotif> findAll() {
        List<EventNotifDao> listDao = this.eventNotifRepository.findAll();
        return listDao.stream().map(eventNotif -> modelMapper.map(eventNotif, EventNotif.class)).collect(Collectors.toList());
    }

    @Override
    public void addUserToEventNotif(String eventNotifId, String userId) {
        NotificationGroupDao notificationGroup = this.eventNotifRepository.findByEventNotifId(eventNotifId).getNotificationGroupDao();
        this.userNotifRepository.findByUserId(userId).getNotifications().add(notificationRepository.findByNotificationId(notificationGroupRepository.findByNotificationGroupId(notificationGroup.getNotificationGroupId()).getNotificationId()));
        this.userNotifRepository.findByUserId(userId).getNotificationGroups().add(notificationGroupRepository.findByNotificationGroupId(notificationGroup.getNotificationGroupId()));
        this.userNotifRepository.save(this.userNotifRepository.findByUserId(userId));
    }

    @Override
    public void deleteEventNotif(String eventNotifId) {
        NotificationGroupDao notificationGroupDao = this.eventNotifRepository.findByEventNotifId(eventNotifId).getNotificationGroupDao();
        this.eventNotifRepository.delete(eventNotifRepository.findByEventNotifId(eventNotifId));
        this.notificationGroupRepository.delete(notificationGroupRepository.findByNotificationGroupId(notificationGroupDao.getNotificationGroupId()));

//        for(NotificationDao notificationDao : notificationGroupDao.getNotifications()) {
//            this.notificationRepository.delete(notificationRepository.findByNotificationId(notificationDao.getNotificationId()));
//        }
    }
}