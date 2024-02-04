package Tydek.billmanager.models.customerFolder;

import Tydek.billmanager.models.enums.Civility;
import Tydek.billmanager.models.enums.Nationality;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;


@Entity
@Data
public abstract class CustomerFolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCustomerFolder;
    private String idCustomer;
    private String idAppointment;
    private String deceasedFirstName;
    private String deceasedLastName;
    private Nationality deceasedNationality;
    private Civility deceasedCivility;
    private long TVA;

    public static CustomerFolder getCustomerFolderInstance() {
        return CustomerFolderFactory.getCustomerFolder(null);
    }
    public static CustomerFolder getCustomerFolderInstance(Nationality nationality) {
        return CustomerFolderFactory.getCustomerFolder(nationality);
    }

    public abstract int numberOfStep();

    public abstract List<CustomerFolderField> getFieldsForStep(int stepNumber);

    public abstract List<CustomerFolderField> getDocumentListToUpload();

}
