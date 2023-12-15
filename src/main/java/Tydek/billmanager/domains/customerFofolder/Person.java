package Tydek.billmanager.domains.customerFofolder;

import Tydek.billmanager.domains.enums.Nationality;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person implements Customer {
    @Id
    private String idPerson;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Nationality nationality;

    @Override
    public String getCustomerId() {
        return this.getIdPerson();
    }
}
