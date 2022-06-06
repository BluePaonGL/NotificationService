package fr.isep.notificationservice.application.port;

import fr.isep.notificationservice.application.DTO.EventNotifDto;
import fr.isep.notificationservice.domain.model.EventNotif;

public interface EventNotifPort {
    EventNotif saveNotification(EventNotifDto eventNotifDto);
}
