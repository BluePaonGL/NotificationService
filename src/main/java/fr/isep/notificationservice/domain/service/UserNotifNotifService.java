package fr.isep.notificationservice.domain.service;

import fr.isep.notificationservice.application.DTO.UserNotifDto;
import fr.isep.notificationservice.application.port.UserNotifPort;
import fr.isep.notificationservice.domain.model.UserNotif;
import fr.isep.notificationservice.domain.port.UserNotifRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserNotifNotifService implements UserNotifPort {
    private final UserNotifRepositoryPort userNotifRepositoryPort;
    private final ModelMapper modelMapper;

    @Override
    public UserNotif saveUser(UserNotifDto userNotifDto) {
        UserNotif userNotif = modelMapper.map(userNotifDto, UserNotif.class);
        return this.userNotifRepositoryPort.saveUser(userNotif);
    }

    @Override
    public List<UserNotif> getUsers() {
        List<UserNotif> result = this.userNotifRepositoryPort.getUsers();
        return result;
    }
}
