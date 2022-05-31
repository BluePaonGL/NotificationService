package fr.isep.notificationservice.infrastructure.adapter_repository_db.repository;

import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.NotificationGroupDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotificationGroupRepository extends JpaRepository<NotificationGroupDao, Long>, JpaSpecificationExecutor<NotificationGroupDao> {
    NotificationGroupDao findByNotificationGroupId(String id);
}
