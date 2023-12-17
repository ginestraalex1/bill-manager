package Tydek.billmanager.domains.customerFofolder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class CustomerFolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFolder;
    private String idCustomer;
    private String idAppointment;
}
