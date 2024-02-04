package Tydek.billmanager.models.customerFolder;

import java.util.List;

public class FrenchCustomerFolder extends CustomerFolder {
    @Override
    public int numberOfStep() {
        return 0;
    }

    @Override
    public List<CustomerFolderField> getFieldsForStep(int stepNumber) {
        return null;
    }

    @Override
    public List<CustomerFolderField> getDocumentListToUpload() {
        return null;
    }
}
