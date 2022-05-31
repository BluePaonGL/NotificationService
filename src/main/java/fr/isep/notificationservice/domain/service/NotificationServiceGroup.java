package fr.isep.notificationservice.domain.service;

import fr.isep.notificationservice.application.DTO.NotificationGroupDto;
import fr.isep.notificationservice.application.port.NotificationGroupPort;
import fr.isep.notificationservice.domain.model.NotificationGroup;
import fr.isep.notificationservice.domain.port.NotificationGroupRepositoryPort;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.repository.NotificationGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceGroup implements NotificationGroupPort {
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

}
