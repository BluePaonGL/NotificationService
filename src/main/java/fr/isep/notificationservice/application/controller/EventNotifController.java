package fr.isep.notificationservice.application.controller;

import fr.isep.notificationservice.application.DTO.EventNotifDto;
import fr.isep.notificationservice.application.port.EventNotifPort;
import fr.isep.notificationservice.domain.model.EventNotif;
import fr.isep.notificationservice.domain.model.UserNotif;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

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

    @GetMapping("/getEventNotif")
    public ResponseEntity<List<EventNotif>> getEventNotif() {
        return new ResponseEntity<>(this.eventNotifPort.findAll(), HttpStatus.OK);
    }

    @PostMapping("/{eventNotifId}/addUser/{userId}")
    public void addUserToEventNotif(@PathVariable String eventNotifId, @PathVariable String userId) {
        this.eventNotifPort.addUser(eventNotifId, userId);
    }

    @PostMapping("/{eventNotifId}/delete")
    public void deleteEventNotif(@PathVariable String eventNotifId) {
        this.eventNotifPort.deleteEventNotif(eventNotifId);
    }
}