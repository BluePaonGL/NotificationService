package fr.isep.notificationservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {
    private String notificationId;
    private String channel;
    private String object;
    private String subtitle;
    private String content;
    private String type;
}
