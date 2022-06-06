package fr.isep.notificationservice.domain.service;

import fr.isep.notificationservice.application.DTO.NotificationGroupDto;
import fr.isep.notificationservice.application.port.NotificationGroupServicePort;
import fr.isep.notificationservice.domain.model.NotificationGroup;
import fr.isep.notificationservice.domain.model.UserNotif;
import fr.isep.notificationservice.domain.port.NotificationGroupRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceGroupService implements NotificationGroupServicePort {
    private final NotificationGroupRepositoryPort notificationGroupRepositoryPort;
    private final ModelMapper modelMapper;

    @Override
    public NotificationGroup saveNotificationGroup(NotificationGroupDto notificationGroupDto) {
        NotificationGroup notificationGroup = modelMapper.map(notificationGroupDto, NotificationGroup.class);
        return this.notificationGroupRepositoryPort.save(notificationGroup);
    }

    @Override
    public List<NotificationGroup> getNotificationGroups() {
        List<NotificationGroup> result = this.notificationGroupRepositoryPort.findAll();
        return result;
    }

    @Override
    public List<UserNotif> getUsersByNotificationGroup(String id) {
        List<UserNotif> result = this.notificationGroupRepositoryPort.getUsersByNotificationGroup(id);
        return result;
    }

    @Override
    public void addUser(String notificationGroupId, String userId) {
        this.notificationGroupRepositoryPort.addUserToNotificationGroup(notificationGroupId, userId);
    }

    @Override
    public void addNotification(String notificationGroupId, String notificationId) {
        this.notificationGroupRepositoryPort.addNotificationToNotificationGroup(notificationGroupId, notificationId);
    }
}