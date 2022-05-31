package fr.isep.notificationservice.application.controller;

import fr.isep.notificationservice.application.DTO.NotificationGroupDto;
import fr.isep.notificationservice.application.port.NotificationGroupPort;
import fr.isep.notificationservice.domain.model.NotificationGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notificationGroup")
@Validated
public class NotificationGroupController {
    private final NotificationGroupPort notificationGroupPort;

    @PostMapping("/addNotificationGroup")
    public ResponseEntity<NotificationGroup> createNotificationGroup(@RequestBody NotificationGroupDto notificationGroupDto) {
        return ResponseEntity.ok(this.notificationGroupPort.saveNotificationGroup(notificationGroupDto));
    }

    @GetMapping("/notificationGroups")
    public ResponseEntity<List<NotificationGroup>> getAllNotificationGroups() {
        return new ResponseEntity<>(this.notificationGroupPort.getNotificationGroups(), HttpStatus.OK);
    }
}
