package Tydek.billmanager.repositories;

import Tydek.billmanager.models.customerFolder.CustomerFolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerFolderRepository extends JpaRepository<CustomerFolder, Long> {
}
