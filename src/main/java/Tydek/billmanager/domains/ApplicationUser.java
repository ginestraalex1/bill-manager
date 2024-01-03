package Tydek.billmanager.domains;

import Tydek.billmanager.domains.enums.Right;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Entity
@Data
public class ApplicationUser {
    @Id
    private String userName;
    private String password;
    private String lastName;
    private String firstName;
    private List<Right> rights;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private boolean isPasswordEnabled;

    public ApplicationUser() {

    }

    public ApplicationUser(
        String userName,
        String lastName,
        String firstName
    ) {
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.isAccountNonExpired = false;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
        this.isPasswordEnabled = false;
    }
    public ApplicationUser(
        String userName,
        String lastName,
        String firstName,
        boolean isAccountNonExpired,
        boolean isAccountNonLocked,
        boolean isCredentialsNonExpired,
        boolean isEnabled,
        boolean isPasswordEnabled
    ) {
        this(userName, lastName, firstName);
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.isPasswordEnabled = isPasswordEnabled;
    }

    public Collection<Right> getAuthorities() {
        return this.rights;
    }

    public String getUsername() {
        return this.userName;
    }

    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }
}
