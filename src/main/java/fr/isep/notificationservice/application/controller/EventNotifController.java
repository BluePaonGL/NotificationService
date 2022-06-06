package fr.isep.notificationservice.application.controller;

import fr.isep.notificationservice.application.DTO.EventNotifDto;
import fr.isep.notificationservice.application.port.EventNotifPort;
import fr.isep.notificationservice.domain.model.EventNotif;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eventNotification")
@Slf4j
public class EventNotifController {
    private final EventNotifPort eventNotifPort;

    @PostMapping("addEventNotification")
    public ResponseEntity<EventNotif> addEventNotification(@RequestBody EventNotifDto eventNotifDto) {
        return ResponseEntity.ok(this.eventNotifPort.saveNotification(eventNotifDto));
    }
}
