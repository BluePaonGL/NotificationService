package fr.isep.notificationService.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationGroup {
    private String groupId;
    private String userId;
    private String notificationId;
}
