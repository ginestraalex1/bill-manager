package Tydek.billmanager.services;

import Tydek.billmanager.domains.ApplicationUser;
import Tydek.billmanager.domains.UserSession;
import Tydek.billmanager.dto.ApplicationUserDTO;
import Tydek.billmanager.repositories.ApplicationUserRepository;
import Tydek.billmanager.repositories.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationUserService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;
    @Autowired
    private UserSessionRepository userSessionRepository;

    public List<ApplicationUserDTO> getAllActiveUsers(){
        return this.applicationUserRepository.findAll().stream()
                .filter(applicationUser -> applicationUser.isEnabled())
                .map(applicationUser -> ApplicationUserDTO.getApplicationUserDTOFromApplicationUser(applicationUser))
                .toList();
    }

    public ApplicationUserDTO getUsersByUsername(String userName) {
        return ApplicationUserDTO.getApplicationUserDTOFromApplicationUser(
                this.applicationUserRepository.findById(userName).get()
        );
    }

    public ApplicationUserDTO createApplicationUser(ApplicationUserDTO applicationUserDTO) {
        ApplicationUserDTO applicationUserDTOToSave = new ApplicationUserDTO(applicationUserDTO);
        ApplicationUser applicationUser = ApplicationUserDTO.getApplicationUserFromApplicationUserDTO(applicationUserDTOToSave);
        applicationUser.setPassword("password");
        ApplicationUser newApplicationUser = this.applicationUserRepository.save(applicationUser);
        return ApplicationUserDTO.getApplicationUserDTOFromApplicationUser(newApplicationUser);
    }


    /**
     * return null if wrong credentials
     * @param userName
     * @param password
     * @return authentication token
     */
    public UserSession verifyCredentialsAndGenerateToken(String userName, String password) {
        ApplicationUser user = this.applicationUserRepository.findById(userName).get();
        if(!user.isPasswordEnabled() || user.getPassword().equals(password)) {
            String token = UUID.randomUUID().toString();
            Optional<UserSession> optionalUserSession = this.userSessionRepository.findById(userName);
            UserSession userSession;
            if (!optionalUserSession.isEmpty()) {
                userSession = optionalUserSession.get();
                this.userSessionRepository.delete(userSession);
            }
            userSession = new UserSession();
            userSession.setUserName(userName);
            userSession.setToken(token);
            userSession.setLastUse(new Date());
            return this.userSessionRepository.save(userSession);
        }
        return null;
    }
}
