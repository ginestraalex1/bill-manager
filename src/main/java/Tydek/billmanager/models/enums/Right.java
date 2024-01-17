package Tydek.billmanager.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Right implements GrantedAuthority {
    READ,
    WRITE;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
