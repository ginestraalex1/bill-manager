package Tydek.billmanager.models.customerFolder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    private long idProduct;
    private long price;
    private String productName;
}
