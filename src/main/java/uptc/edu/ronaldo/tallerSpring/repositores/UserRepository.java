package uptc.edu.ronaldo.tallerSpring.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uptc.edu.ronaldo.tallerSpring.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
}