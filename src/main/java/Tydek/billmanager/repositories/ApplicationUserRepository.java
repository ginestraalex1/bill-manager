package Tydek.billmanager.repositories;

import Tydek.billmanager.domains.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, String> {
}
