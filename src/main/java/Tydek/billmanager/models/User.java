package Tydek.billmanager.models;

import Tydek.billmanager.models.enums.Right;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity()
@Table(name = "BILL_MANAGER_USER")
@Data
public class User implements UserDetails {

    private static PasswordEncoder passwordEncoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Id
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

    public User(){
    }

    public User(String username,
                String password,
                String firstName,
                String lastName,
                Set<Right> rights) {
        this.username = username;
        this.password = passwordEncoder.encode(password);
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

    public User(String username,
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

    public User(User user) {
    }

    public void setPassword(String password) {
        this.password = passwordEncoder.encode(password);
    }

    public boolean isPasswordEquals(String passwordToCompare) {
        return passwordEncoder.matches(passwordToCompare, password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.rights;
    }
}
