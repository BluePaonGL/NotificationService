package fr.isep.notificationservice.application.controller;

import fr.isep.notificationservice.application.DTO.UserDto;
import fr.isep.notificationservice.application.port.UserPort;
import fr.isep.notificationservice.domain.model.User;
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
public class UserController {
    private final UserPort userPort;

    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(this.userPort.saveUser(userDto));
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(this.userPort.getUsers(), HttpStatus.OK);
    }
}
