package Tydek.billmanager.services;

import Tydek.billmanager.models.customerFolder.CustomerFolder;
import Tydek.billmanager.repositories.CustomerFolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerFolderService {

    @Autowired
    private CustomerFolderRepository customerFolderRepository;

    public CustomerFolder createCustomerFolder() {
        return this.customerFolderRepository.save(CustomerFolder.getCustomerFolderInstance());
    }

    public List<CustomerFolder> getAllCustomerFolders() {
        return this.customerFolderRepository.findAll();
    }

    public CustomerFolder getCustomerFolder(long id) {
        Optional<CustomerFolder> res = this.customerFolderRepository.findById(id);
        return res.isEmpty() ? null : res.get();
    }
}
