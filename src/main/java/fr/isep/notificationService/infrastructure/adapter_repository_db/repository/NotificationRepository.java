package fr.isep.notificationService.infrastructure.adapter_repository_db.repository;

import fr.isep.notificationService.infrastructure.adapter_repository_db.DAO.NotificationDao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotificationRepository extends PagingAndSortingRepository<NotificationDao, Long>, JpaSpecificationExecutor<NotificationDao> {
}
