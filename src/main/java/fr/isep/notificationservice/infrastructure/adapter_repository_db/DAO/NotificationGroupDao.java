package fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notification_group")
public class NotificationGroupDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String uniqueId;

    private String userId;
    private String notificationId;
}
