package fr.isep.notificationService.infrastructure.adapter_repository_db.DAO;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notification")
public class NotificationDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String notificationId;

    private String channel;
    private String object;
    private String subtitle;
    private String content;
    private String type;
}
