package fr.isep.notificationservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.isep.notificationservice.domain.model.Enum.NotificationTypeEnum;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.UserNotifDao;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Notification {
    private String notificationId;
    private String channel;
    private String object;
    private String subtitle;
    private String content;
    private NotificationTypeEnum type;

    private NotificationGroup notificationGroup;
    private List<UserNotif> userNotifList = new ArrayList<>();

    @JsonIgnore
    public List<UserNotif> getUserNotifList() {
        return userNotifList;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", channel='" + channel + '\'' +
                ", object='" + object + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", notificationGroup=" + notificationGroup +
                '}';
    }
}