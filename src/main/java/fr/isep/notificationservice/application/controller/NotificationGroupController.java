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

    @GetMapping("/{notificationGroupId}/getUsers")
    public ResponseEntity<List<UserNotif>> getUsersByNotificationGroup(@PathVariable String notificationGroupId) {
        return new ResponseEntity<>(this.notificationGroupServicePort.getUsersByNotificationGroup(notificationGroupId), HttpStatus.OK);
    }

    @PostMapping("{notificationGroupId}/addUser/{userId}")
    public void addUserToNotificationGroup(@PathVariable String notificationGroupId, @PathVariable String userId) {
        this.notificationGroupServicePort.addUser(notificationGroupId, userId);
    }

    @PostMapping("/{notificationGroupId}/addNotification/{notificationId}")
    public void addNotificationToNotificationGroup(@PathVariable String notificationGroupId, @PathVariable String notificationId) {
        this.notificationGroupServicePort.addNotification(notificationGroupId, notificationId);
    }

    @PostMapping("/{notificationGroupId}/delete")
    public void deleteNotificationGroup(@PathVariable String notificationGroupId) {
        this.notificationGroupServicePort.deleteNotificationGroup(notificationGroupId);
    }
}