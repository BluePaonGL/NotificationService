package fr.isep.notificationservice.application.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class NotificationGroupDto {
    private String notificationGroupId;
    private String userId;
    private String notificationId;
}
