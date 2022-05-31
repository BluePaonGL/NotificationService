package fr.isep.notificationservice.domain.model.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum NotificationTypeEnum {
    EVENT("event");

    @Getter
    private final String value;
}
