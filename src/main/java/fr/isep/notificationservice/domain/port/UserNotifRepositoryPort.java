package fr.isep.notificationservice.domain.port;

import fr.isep.notificationservice.domain.model.UserNotif;

import java.util.List;

public interface UserNotifRepositoryPort {
    UserNotif saveUser(UserNotif userNotif);

    List<UserNotif> getUsers();
}
