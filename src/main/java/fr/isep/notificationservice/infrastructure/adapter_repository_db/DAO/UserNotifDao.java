package fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class UserNotifDao {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String userId;

    @ManyToMany
    @JoinTable(name = "user_group_association_table",
            joinColumns = @JoinColumn(name = "userNotifId"),
            inverseJoinColumns = @JoinColumn(name = "notificationGroupId"))
    private List<NotificationGroupDao> notificationGroups = new ArrayList<>();
}
