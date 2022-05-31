package fr.isep.notificationservice.application.port;

import fr.isep.notificationservice.application.DTO.UserDto;
import fr.isep.notificationservice.domain.model.User;

import java.util.List;

public interface UserPort {
    User saveUser(UserDto userDto);

    List<User> getUsers();
}
