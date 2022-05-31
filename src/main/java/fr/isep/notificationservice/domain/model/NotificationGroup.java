package fr.isep.notificationservice.domain.model;

import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.UserDao;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NotificationGroup {
    private String notificationGroupId;
    private String userId;
    private String notificationId;
    private List<User> userList = new ArrayList<>();
}
