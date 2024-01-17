package Tydek.billmanager.models.customerFolder;

import Tydek.billmanager.models.enums.Civility;
import Tydek.billmanager.models.enums.Nationality;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPerson;
    private String firstName;
    private String lastName;
    private Civility civility;
    private String email;
    private String phoneNumber;
    private Nationality nationality;
}
