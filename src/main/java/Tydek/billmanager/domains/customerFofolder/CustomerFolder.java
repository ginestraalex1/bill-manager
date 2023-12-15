package Tydek.billmanager.domains.customerFofolder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class CustomerFolder {
    @Id
    private String idFolder;
    private String idCustomer;
}
