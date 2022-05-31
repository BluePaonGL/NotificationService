package fr.isep.notificationservice.domain.model;

import lombok.Data;
@Data
public class NotificationGroup {
    private String notificationGroupId;
    private String userId;
    private String notificationId;
}
