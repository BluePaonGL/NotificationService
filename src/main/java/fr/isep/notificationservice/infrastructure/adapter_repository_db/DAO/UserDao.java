package fr.isep.notificationservice.infrastructure.adapter_repository_db.DAO;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;

    @ManyToMany
    @JoinTable(name = "user_group_association_table",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idRole"))
    private List<NotificationGroupDao> notificationGroups = new ArrayList<>();
}
