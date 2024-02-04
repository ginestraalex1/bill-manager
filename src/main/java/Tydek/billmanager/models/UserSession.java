package Tydek.billmanager.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class UserSession {
    @Id
    private String userName;
    private String token;
    private Date lastUse;
}
