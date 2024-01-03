package Tydek.billmanager.controllers;

import Tydek.billmanager.domains.UserSession;
import Tydek.billmanager.dto.ApplicationUserDTO;
import Tydek.billmanager.dto.AuthDTO;
import Tydek.billmanager.services.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("application-user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApplicationUserController {

    @Autowired
    private ApplicationUserService applicationUserService;

    @PostMapping()
    public ResponseEntity<ApplicationUserDTO> createApplicationUser(@RequestBody ApplicationUserDTO body) {
        System.out.println(body.toString());
        return ResponseEntity.ok(applicationUserService.createApplicationUser(body));
    }

    @GetMapping()
    public ResponseEntity<List<ApplicationUserDTO>> getAllApplicationUsers() {
        return ResponseEntity.ok(applicationUserService.getAllActiveUsers());
    }

    @GetMapping("/{userName}")
    public ResponseEntity<ApplicationUserDTO> getApplicationUser(@PathVariable String userName) {
        return ResponseEntity.ok(applicationUserService.getUsersByUsername(userName));
    }



    @PostMapping("/login")
    public ResponseEntity<UserSession> loginApplicationUser(@RequestBody AuthDTO body) {
        UserSession token = this.applicationUserService.verifyCredentialsAndGenerateToken(body.getUserName(), body.getPassword());
        if (token == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(token);
    }
}
