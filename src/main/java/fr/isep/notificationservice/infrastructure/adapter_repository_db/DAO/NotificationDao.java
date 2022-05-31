package fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO;

import fr.isep.notificationservice.domain.model.Enum.NotificationTypeEnum;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notification")
public class NotificationDao {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String notificationId;

    private String channel;
    private String object;
    private String subtitle;
    private String content;
    private NotificationTypeEnum type;

    @ManyToOne
    private NotificationGroupDao notificationGroup;
}
