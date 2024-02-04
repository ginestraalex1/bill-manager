package Tydek.billmanager.dto;

import Tydek.billmanager.models.User;
import Tydek.billmanager.models.enums.Right;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Right> rights = new HashSet<>();
    private boolean passwordEnabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public UserDTO(){}

    public UserDTO(String username,
                   String password,
                   String firstName,
                   String lastName,
                   Set<Right> rights) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        if (rights != null) {
            for(Right r : rights){
                this.rights.add(r);
            }
        }
        this.enabled = true;
        this.accountNonExpired = true;
        this.credentialsNonExpired = true;
        this.accountNonLocked = true;
        this.passwordEnabled = true;
    }

    public UserDTO(String username,
                   String password,
                   String firstName,
                   String lastName,
                   Set<Right> rights,
                   boolean enabled,
                   boolean accountNonExpired,
                   boolean credentialsNonExpired,
                   boolean accountNonLocked,
                   boolean passwordEnabled) {
        this(username,password,firstName,lastName,rights);
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.passwordEnabled = passwordEnabled;
    }



    public UserDTO(UserDTO userDTO) {
        this.username = userDTO.getUsername();
        this.lastName = userDTO.getLastName();
        this.firstName = userDTO.getFirstName();
        this.password = userDTO.getPassword();
        this.accountNonExpired = userDTO.isAccountNonExpired();
        this.accountNonLocked = userDTO.isAccountNonLocked();
        this.credentialsNonExpired = userDTO.isCredentialsNonExpired();
        this.enabled = userDTO.isEnabled();
        this.passwordEnabled = userDTO.isPasswordEnabled();
    }


    public static UserDTO getDTOFromUser(User user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        userDTO.setPassword(null);
        return userDTO;
    }

    public static User getUserFromDTO(UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }
}
