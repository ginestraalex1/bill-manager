package Tydek.billmanager.domains.customerFofolder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Company implements Customer {

    @Id
    private String idCompany;

    @Override
    public String getCustomerId() {
        return this.getIdCompany();
    }
}
