package fr.isep.notificationservice.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String userId;
    private List<NotificationGroup> notificationGroups;
}
