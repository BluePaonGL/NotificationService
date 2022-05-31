package fr.isep.notificationservice.application.port;

import fr.isep.notificationservice.application.DTO.UserNotifDto;
import fr.isep.notificationservice.domain.model.UserNotif;

import java.util.List;

public interface UserNotifPort {
    UserNotif saveUser(UserNotifDto userNotifDto);

    List<UserNotif> getUsers();
}
