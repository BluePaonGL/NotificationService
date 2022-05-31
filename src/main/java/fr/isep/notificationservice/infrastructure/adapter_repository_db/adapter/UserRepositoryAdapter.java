package fr.isep.notificationservice.infrastructure.adapter_repository_db.adapter;

import fr.isep.notificationservice.domain.model.User;
import fr.isep.notificationservice.domain.port.UserRepositoryPort;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.UserDao;
import fr.isep.notificationservice.infrastructure.adapter_repository_db.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final ModelMapper modelMapper;
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        UserDao userDao = modelMapper.map(user, UserDao.class);
        return modelMapper.map(this.userRepository.save(userDao), User.class);
    }

    @Override
    public List<User> getUsers() {
        List<UserDao> userDaoList = this.userRepository.findAll();
        return userDaoList.stream().map(user -> modelMapper.map(user, User.class)).collect(Collectors.toList());
    }
}
