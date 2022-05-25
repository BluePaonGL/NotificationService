package fr.isep.notificationservice.infrastructure.adapter_repository_db.repository;

import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.NotificationDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotificationRepository extends JpaRepository<NotificationDao, Long>, JpaSpecificationExecutor<NotificationDao> {
}
