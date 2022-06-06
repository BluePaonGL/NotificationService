package fr.isep.notificationservice.application.controller;

import fr.isep.notificationservice.application.DTO.UserNotifDto;
import fr.isep.notificationservice.application.port.UserNotifPort;
import fr.isep.notificationservice.domain.model.UserNotif;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Validated
public class UserNotifController {
    private final UserNotifPort userNotifPort;

    @PostMapping("/addUser")
    public ResponseEntity<UserNotif> createUser(@RequestBody UserNotifDto userNotifDto) {
        return ResponseEntity.ok(this.userNotifPort.saveUser(userNotifDto));
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserNotif>> getUsers() {
        return new ResponseEntity<>(this.userNotifPort.getUsers(), HttpStatus.OK);
    }
}