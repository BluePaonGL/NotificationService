package fr.isep.notificationservice.application.controller;

import fr.isep.notificationservice.application.DTO.NotificationDto;
import fr.isep.notificationservice.application.port.NotificationServicePort;
import fr.isep.notificationservice.domain.model.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
