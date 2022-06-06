package fr.isep.notificationservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NotificationGroup {
    private String notificationGroupId;
    private String notificationId;
    private List<UserNotif> userNotifList = new ArrayList<>();

    @Override
    public String toString() {
        return "NotificationGroup{" +
                "notificationGroupId='" + notificationGroupId + '\'' +
                ", notificationId='" + notificationId + '\'' +
                ", userNotifList=" + userNotifList +
                '}';
    }
}