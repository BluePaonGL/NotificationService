package fr.isep.notificationservice.application.port;

import fr.isep.notificationservice.application.DTO.EventNotifDto;
import fr.isep.notificationservice.domain.model.EventNotif;

import java.util.List;

public interface EventNotifPort {
    EventNotif saveNotification(EventNotifDto eventNotifDto);

    List<EventNotif> findAll();

    void addUser(String eventNotifId, String userId);
}