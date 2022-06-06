package fr.isep.notificationservice.infrastructure.adapter_repository_db.repository;

import fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO.EventNotifDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EventNotifRepository extends JpaRepository<EventNotifDao, Long>, JpaSpecificationExecutor<EventNotifDao> {
}
