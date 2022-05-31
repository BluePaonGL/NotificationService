package fr.isep.notificationservice.domain.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NotificationGroup {
    private String notificationGroupId;
    private String userId;
    private String notificationId;
    private List<UserNotif> userNotifList = new ArrayList<>();
}
