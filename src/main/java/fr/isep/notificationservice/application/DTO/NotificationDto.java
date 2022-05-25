package fr.isep.notificationservice.application.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class NotificationDto implements Serializable {
    @NotNull
    @NotEmpty
    private String object;

    @NotNull
    @NotEmpty
    private String type;

    private String channel;
    private String subtitle;
    private String content;

}
