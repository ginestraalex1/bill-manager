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
public abstract class CustomerFolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFolder;
    private String idCustomer;
    private String idAppointment;
    private Nationality deceasedNationality;
    private long idPerson;
    private String firstName;
    private String lastName;
    private Civility civility;
    private String email;
    private String phoneNumber;
    private Nationality nationality;

    public static CustomerFolder getCustomerFolderInstance() {
        return CustomerFolderFactory.getCustomerFolder(null);
    }
    public static CustomerFolder getCustomerFolderInstance(Nationality nationality) {
        return CustomerFolderFactory.getCustomerFolder(nationality);
    }
}
