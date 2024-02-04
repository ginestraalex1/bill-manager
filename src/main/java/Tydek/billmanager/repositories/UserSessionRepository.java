package Tydek.billmanager.repositories;

import Tydek.billmanager.models.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSessionRepository extends JpaRepository<UserSession, String> {
}
