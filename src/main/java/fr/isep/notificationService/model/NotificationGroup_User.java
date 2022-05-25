package fr.isep.notificationService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationGroup_User {
    private String uniqueId;
    private String userId;
    private String notificationId;
}
