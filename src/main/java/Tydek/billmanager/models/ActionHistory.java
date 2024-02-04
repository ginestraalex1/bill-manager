package Tydek.billmanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ActionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAction;
    private String userNameResponsible;
    private String customerFolderRelated;
}
