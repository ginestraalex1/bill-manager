package Tydek.billmanager.models.enums;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;

public class Authority {

    public static Collection<? extends GrantedAuthority> getAuthorities(Right[] rights) {
        Collection<GrantedAuthority> authorities = new HashSet<>();
        for (Right right : rights) {
            switch (right) {
                case READ -> authorities.add(new SimpleGrantedAuthority(Right.READ.name()));
                case WRITE -> authorities.add(new SimpleGrantedAuthority(Right.WRITE.name()));
            }
        }
        return authorities;
    }
}
