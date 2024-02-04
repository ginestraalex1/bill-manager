package Tydek.billmanager.models.customerFolder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Sale {

    @Id
    private long idSales;
    private long idCustomerFolder;
    private long idProduct;
    private int quantity;

}
