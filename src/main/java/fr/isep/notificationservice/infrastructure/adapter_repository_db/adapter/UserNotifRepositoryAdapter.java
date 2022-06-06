package fr.isep.notificationservice.infrastructure.adapter_repository_db.adapter;

import fr.isep.notificationservice.domain.model.UserNotif;
import fr.isep.notificationservice.domain.port.UserNotifRepositoryPort;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.UserNotifDao;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.repository.UserNotifRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserNotifRepositoryAdapter implements UserNotifRepositoryPort {
    private final ModelMapper modelMapper;
    private UserNotifRepository userNotifRepository;

    @Override
    public UserNotif saveUser(UserNotif userNotif) {
        UserNotifDao userNotifDao = modelMapper.map(userNotif, UserNotifDao.class);
        return modelMapper.map(this.userNotifRepository.save(userNotifDao), UserNotif.class);
    }

    @Override
    public List<UserNotif> getUsers() {
        List<UserNotifDao> userNotifDaoList = this.userNotifRepository.findAll();
        return userNotifDaoList.stream().map(user -> modelMapper.map(user, UserNotif.class)).collect(Collectors.toList());
    }
}