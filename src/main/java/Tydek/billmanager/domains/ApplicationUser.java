package Tydek.billmanager.domains;

import Tydek.billmanager.domains.enums.Right;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ApplicationUser {
    @Id
    private String userName;
    private String lastName;
    private String firstName;
    private List<Right> rights;
}
