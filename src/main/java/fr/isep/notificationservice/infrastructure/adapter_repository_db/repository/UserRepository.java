package fr.isep.notificationservice.infrastructure.adapter_repository_db.repository;

import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<UserDao, Long>, JpaSpecificationExecutor<UserDao> {
    UserDao findByUserId(String id);
}
