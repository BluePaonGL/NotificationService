package fr.isep.notificationservice.application.controller;

import fr.isep.notificationservice.application.DTO.NotificationDto;
import fr.isep.notificationservice.application.port.NotificationServicePort;
import fr.isep.notificationservice.domain.model.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
@Slf4j
public class NotificationController {
    private final NotificationServicePort notificationServicePort;

    @PostMapping("addNotification")
    public ResponseEntity<Notification> createNotification(@RequestBody NotificationDto notificationDto) {
        return ResponseEntity.ok(this.notificationServicePort.saveNotification(notificationDto));
    }

    @PostMapping("{notificationId}/addTo/{notificationGroupId}")
    public void addNotificationToNotificationGroup(@PathVariable String notificationId, @PathVariable String notificationGroupId) {
        this.notificationServicePort.addNotification(notificationId, notificationGroupId);
    }

    @GetMapping("/getNotifications")
    public ResponseEntity<List<Notification>> getNotifications() {
        return new ResponseEntity<>(this.notificationServicePort.findAll(), HttpStatus.OK);
    }
}
