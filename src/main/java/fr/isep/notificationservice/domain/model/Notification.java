package fr.isep.notificationservice.domain.model;

import fr.isep.notificationservice.domain.model.Enum.NotificationTypeEnum;
import lombok.Data;

@Data
public class Notification {
    private String notificationId;
    private String channel;
    private String object;
    private String subtitle;
    private String content;
    private NotificationTypeEnum type;

    private NotificationGroup notificationGroup;
}
