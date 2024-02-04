package Tydek.billmanager.services;

import Tydek.billmanager.dto.Credentials;
import Tydek.billmanager.models.User;
import Tydek.billmanager.models.UserSession;
import Tydek.billmanager.dto.UserDTO;
import Tydek.billmanager.repositories.UserRepository;
import Tydek.billmanager.repositories.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserSessionRepository userSessionRepository;

    public List<UserDTO> getAllActiveUsers(){
        return this.userRepository.findAll().stream()
                .filter(user -> user.isEnabled())
                .map(user -> UserDTO.getDTOFromUser(user))
                .toList();
    }

    public UserDTO getUsersByUsername(String userName) {
        return UserDTO.getDTOFromUser(
                this.userRepository.findById(userName).get()
        );
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = UserDTO.getUserFromDTO(userDTO);
        return UserDTO.getDTOFromUser(this.userRepository.save(user));
    }


    /**
     * return null if wrong credentials
     * @param credentials credentials to get a token
     * @return authentication token
     */
    public UserSession verifyCredentialsAndGenerateToken(Credentials credentials) {
        User user = this.userRepository.findById(credentials.getUsername()).get();
        if(!user.isPasswordEnabled() || user.isPasswordEquals(credentials.getPassword())) {
            String token = UUID.randomUUID().toString();
            Optional<UserSession> optionalUserSession = this.userSessionRepository.findById(credentials.getUsername());
            UserSession userSession;
            if (!optionalUserSession.isEmpty()) {
                userSession = optionalUserSession.get();
                this.userSessionRepository.delete(userSession);
            }
            userSession = new UserSession();
            userSession.setUserName(credentials.getUsername());
            userSession.setToken(token);
            userSession.setLastUse(new Date());
            return this.userSessionRepository.save(userSession);
        }
        return null;
    }
}
