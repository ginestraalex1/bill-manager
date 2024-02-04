package Tydek.billmanager.controllers;

import Tydek.billmanager.dto.Credentials;
import Tydek.billmanager.models.UserSession;
import Tydek.billmanager.dto.UserDTO;
import Tydek.billmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO body) {
        return ResponseEntity.ok(userService.createUser(new UserDTO(body)));
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllActiveUsers());
    }

    @GetMapping("/{userName}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String userName) {
        return ResponseEntity.ok(userService.getUsersByUsername(userName));
    }

    @PostMapping("/login")
    public ResponseEntity<UserSession> loginUser(@RequestBody Credentials body) {
        UserSession token = this.userService.verifyCredentialsAndGenerateToken(new Credentials(body));
        if (token == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(token);
    }
}
