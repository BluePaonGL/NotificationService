package fr.isep.notificationservice.infrastructure.adapter_repository_db.adapter;

import fr.isep.notificationservice.domain.model.NotificationGroup;
import fr.isep.notificationservice.domain.model.UserNotif;
import fr.isep.notificationservice.domain.port.NotificationGroupRepositoryPort;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.NotificationGroupDao;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.UserNotifDao;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.repository.NotificationGroupRepository;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.repository.UserNotifRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class NotificationGroupRepositoryAdapter implements NotificationGroupRepositoryPort {
    private final ModelMapper modelMapper;
    private NotificationGroupRepository notificationGroupRepository;
    private UserNotifRepository userNotifRepository;

    @Override
    public NotificationGroup save(NotificationGroup notificationGroup) {
        NotificationGroupDao notificationGroupDao = modelMapper.map(notificationGroup, NotificationGroupDao.class);
        return modelMapper.map(this.notificationGroupRepository.save(notificationGroupDao), NotificationGroup.class);
    }

    @Override
    public List<NotificationGroup> findAll() {
        List<NotificationGroupDao> listDAO = this.notificationGroupRepository.findAll();
        return listDAO.stream().map(notificationGroup -> modelMapper.map(notificationGroup, NotificationGroup.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserNotif> getUsersByNotificationGroup(String id) {
        List<UserNotifDao> listDao = this.userNotifRepository.findAll();
        return listDao.stream().map(user -> modelMapper.map(user, UserNotif.class)).collect(Collectors.toList());
    }

    @Override
    public NotificationGroup getNotificationGroupById(String id) {
        return modelMapper.map(this.notificationGroupRepository.findByNotificationGroupId(id), NotificationGroup.class);
    }

    @Override
    public void addUserToNotificationGroup(String notificationGroupId, String userId) {
        this.notificationGroupRepository.findByNotificationGroupId(notificationGroupId).getUserNotifDaoList().add(userNotifRepository.findByUserId(userId));
        this.userNotifRepository.findByUserId(userId).getNotificationGroups().add(notificationGroupRepository.findByNotificationGroupId(notificationGroupId));
    }
}
