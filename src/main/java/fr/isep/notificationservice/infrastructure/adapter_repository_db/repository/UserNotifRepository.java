package fr.isep.notificationservice.infrastructure.adapter_repository_db.repository;

import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.UserNotifDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserNotifRepository extends JpaRepository<UserNotifDao, Long>, JpaSpecificationExecutor<UserNotifDao> {
    UserNotifDao findByUserId(String id);
}
