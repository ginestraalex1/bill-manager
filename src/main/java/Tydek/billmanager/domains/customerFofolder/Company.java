package Tydek.billmanager.domains.customerFofolder;

import Tydek.billmanager.domains.enums.Nationality;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Company implements Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompany;
    private String name;
    private String email;
    private String phoneNumber;
    private Nationality nationality;

    @Override
    public long getCustomerId() {
        return this.getIdCompany();
    }
}
