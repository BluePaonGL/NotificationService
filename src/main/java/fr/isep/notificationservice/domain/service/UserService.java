package fr.isep.notificationservice.domain.service;

import fr.isep.notificationservice.application.DTO.UserDto;
import fr.isep.notificationservice.application.port.UserPort;
import fr.isep.notificationservice.domain.model.User;
import fr.isep.notificationservice.domain.port.NotificationGroupRepositoryPort;
import fr.isep.notificationservice.domain.port.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserPort {
    private final UserRepositoryPort userRepositoryPort;
    private final ModelMapper modelMapper;

    @Override
    public User saveUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return this.userRepositoryPort.saveUser(user);
    }

    @Override
    public List<User> getUsers() {
        List<User> result = this.userRepositoryPort.getUsers();
        return result;
    }
}
