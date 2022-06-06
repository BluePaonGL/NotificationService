package fr.isep.notificationservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.NotificationDao;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserNotif {
    private String userId;
    private List<NotificationGroup> notificationGroups;
    private List<Notification> notifications = new ArrayList<>();

    @JsonIgnore
    public List<NotificationGroup> getNotificationGroups() {
        return notificationGroups;
    }

    @Override
    public String toString() {
        return "UserNotif{" +
                "userId='" + userId + '\'' +
                ", notificationGroups=" + notificationGroups +
                '}';
    }
}