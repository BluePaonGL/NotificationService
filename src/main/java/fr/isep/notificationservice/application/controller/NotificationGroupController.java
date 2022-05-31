package fr.isep.notificationservice.application.controller;

import fr.isep.notificationservice.application.DTO.NotificationGroupDto;
import fr.isep.notificationservice.application.port.NotificationGroupServicePort;
import fr.isep.notificationservice.domain.model.NotificationGroup;
import fr.isep.notificationservice.domain.model.UserNotif;
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
    private final NotificationGroupServicePort notificationGroupServicePort;

    @PostMapping("/addNotificationGroup")
    public ResponseEntity<NotificationGroup> createNotificationGroup(@RequestBody NotificationGroupDto notificationGroupDto) {
        return ResponseEntity.ok(this.notificationGroupServicePort.saveNotificationGroup(notificationGroupDto));
    }

    @GetMapping("/notificationGroups")
    public ResponseEntity<List<NotificationGroup>> getAllNotificationGroups() {
        return new ResponseEntity<>(this.notificationGroupServicePort.getNotificationGroups(), HttpStatus.OK);
    }

    @GetMapping("/{id}/getUsers")
    public ResponseEntity<List<UserNotif>> getUsersByNotificationGroup(@PathVariable String id) {
        return new ResponseEntity<>(this.notificationGroupServicePort.getUsersByNotificationGroup(id), HttpStatus.OK);
    }

    @PostMapping("{notificationGroupId}/add/{userId}")
    public void addUserToNotificationGroup(@PathVariable String notificationGroupId, @PathVariable String userId) {
        this.notificationGroupServicePort.addUser(notificationGroupId, userId);
    }
}
