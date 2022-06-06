package fr.isep.notificationservice.domain.model;

import lombok.Data;

@Data
public class EventNotif {
    private String eventNotifId;
    private String eventId;
    private NotificationGroup notificationGroup;
}