package fr.isep.notificationservice.domain.port;

import fr.isep.notificationservice.domain.model.User;

import java.util.List;

public interface UserRepositoryPort {
    User saveUser(User user);

    List<User> getUsers();
}
