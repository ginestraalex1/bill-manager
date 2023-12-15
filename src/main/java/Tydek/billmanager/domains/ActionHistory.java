package Tydek.billmanager.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ActionHistory {
    @Id
    private String idAction;
    private String userNameResponsible;
    private String customerFolderRelated;
}
