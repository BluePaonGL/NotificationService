package fr.isep.notificationservice.domain.service;

import fr.isep.notificationservice.application.DTO.EventNotifDto;
import fr.isep.notificationservice.application.port.EventNotifPort;
import fr.isep.notificationservice.domain.model.EventNotif;
import fr.isep.notificationservice.domain.port.EventNotifRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class EventNotifService implements EventNotifPort {
    private final ModelMapper modelMapper;
    private final EventNotifRepositoryPort eventNotifRepositoryPort;

    @Override
    public EventNotif saveNotification(EventNotifDto eventNotifDto) {
        EventNotif eventNotif = modelMapper.map(eventNotifDto, EventNotif.class);
        return this.eventNotifRepositoryPort.saveEventNotification(eventNotif);
    }

    @Override
    public List<EventNotif> findAll() {
        List<EventNotif> result = this.eventNotifRepositoryPort.findAll();
        return result;
    }

    @Override
    public void addUser(String eventNotifId, String userId) {
        this.eventNotifRepositoryPort.addUserToEventNotif(eventNotifId, userId);
    }
}