package fr.isep.notificationservice.domain.port;

import fr.isep.notificationservice.domain.model.EventNotif;

public interface EventNotifRepositoryPort {
    EventNotif saveEventNotification(EventNotif eventNotif);
}
