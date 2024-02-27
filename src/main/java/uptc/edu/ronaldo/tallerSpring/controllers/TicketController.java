package uptc.edu.ronaldo.tallerSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uptc.edu.ronaldo.tallerSpring.entities.Ticket;
import uptc.edu.ronaldo.tallerSpring.entities.User;
import uptc.edu.ronaldo.tallerSpring.services.TicketService;
import uptc.edu.ronaldo.tallerSpring.services.UserService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = ticketService.readTicket(id);
        if (ticket != null) {
            return ResponseEntity.ok(ticket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        User assignedUser = userService.getById(ticket.getAssignedUser().getId()); // Obtener el usuario asignado desde el ticket directamente

        if (assignedUser == null) {
            return ResponseEntity.badRequest().build();
        }

        ticket.setAssignedUser(assignedUser);

        ticketService.addTicket(ticket);

        return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }

    @PutMapping("/{id}/close")
    public ResponseEntity<Void> closeTicket(@PathVariable Long id) {
        ticketService.closeTicket(id);
        return ResponseEntity.ok().build();
    }
}