package Tydek.billmanager.dto;

import Tydek.billmanager.domains.ApplicationUser;
import Tydek.billmanager.domains.enums.Right;
import lombok.Data;

import java.util.List;

@Data
public class ApplicationUserDTO {

    private String userName;
    private String lastName;
    private String firstName;
    private List<Right> rights;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private boolean isPasswordEnabled;

    public ApplicationUserDTO(
            String userName,
            String lastName,
            String firstName,
            boolean isAccountNonExpired,
            boolean isAccountNonLocked,
            boolean isCredentialsNonExpired,
            boolean isEnabled,
            boolean isPasswordEnabled
    ) {
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.isPasswordEnabled = isPasswordEnabled;
    }



    public ApplicationUserDTO(ApplicationUserDTO applicationUserDTO) {
        this.userName = applicationUserDTO.getUserName();
        this.lastName = applicationUserDTO.getLastName();
        this.firstName = applicationUserDTO.getFirstName();
        this.isAccountNonExpired = applicationUserDTO.isAccountNonExpired();
        this.isAccountNonLocked = applicationUserDTO.isAccountNonLocked();
        this.isCredentialsNonExpired = applicationUserDTO.isCredentialsNonExpired();
        this.isEnabled = applicationUserDTO.isEnabled();
        this.isPasswordEnabled = applicationUserDTO.isPasswordEnabled();
    }

    public static ApplicationUserDTO getApplicationUserDTOFromApplicationUser(ApplicationUser applicationUser) {
        return new ApplicationUserDTO(
                applicationUser.getUsername(),
                applicationUser.getLastName(),
                applicationUser.getFirstName(),
                applicationUser.isAccountNonExpired(),
                applicationUser.isAccountNonLocked(),
                applicationUser.isCredentialsNonExpired(),
                applicationUser.isEnabled(),
                applicationUser.isPasswordEnabled()
            );
    }

    public static ApplicationUser getApplicationUserFromApplicationUserDTO(ApplicationUserDTO applicationUserDTO) {
        return new ApplicationUser(
                applicationUserDTO.getUserName(),
                applicationUserDTO.getLastName(),
                applicationUserDTO.getFirstName(),
                applicationUserDTO.isAccountNonExpired(),
                applicationUserDTO.isAccountNonLocked(),
                applicationUserDTO.isCredentialsNonExpired(),
                applicationUserDTO.isEnabled(),
                applicationUserDTO.isPasswordEnabled()
        );
    }
}
