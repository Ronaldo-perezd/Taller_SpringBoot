package uptc.edu.ronaldo.tallerSpring.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uptc.edu.ronaldo.tallerSpring.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}

