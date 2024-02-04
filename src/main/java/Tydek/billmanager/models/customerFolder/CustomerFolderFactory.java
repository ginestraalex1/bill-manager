package Tydek.billmanager.models.customerFolder;

import Tydek.billmanager.models.enums.Nationality;

public class CustomerFolderFactory {

    public static CustomerFolder getCustomerFolder(Nationality customerNationality) {
        switch (customerNationality) {
            case BE -> {
                return new BelgianCustomerFolder();
            }
            default -> {
                return new FrenchCustomerFolder();
            }
        }
    }
}
