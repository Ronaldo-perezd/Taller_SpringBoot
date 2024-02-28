package uptc.edu.ronaldo.tallerSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.edu.ronaldo.tallerSpring.repositores.TicketRepository;
import uptc.edu.ronaldo.tallerSpring.entities.Ticket;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket readTicket(Long ticketId) {
        return ticketRepository.findById(ticketId).orElse(null);
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void closeTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket != null) {
            ticket.setStatus("Closed");
            ticketRepository.save(ticket);
        }
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}