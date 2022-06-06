package fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eventNotification")
public class EventNotifDao {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String eventNotifId;
    private String eventId;

    @ManyToOne
    @JoinColumn(name = "notification_group_dao_notification_group_id")
    private NotificationGroupDao notificationGroupDao;
}