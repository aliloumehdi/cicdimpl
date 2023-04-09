package ma.learning.cicdimpl.repositories;

import ma.learning.cicdimpl.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}