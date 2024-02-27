package uptc.edu.ronaldo.tallerSpring.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name = "assignedUserId")
    private User assignedUser;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Ticket() {
        // Constructor vacío necesario para JPA
    }

    public Ticket(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // Constructores, getters y setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    // Métodos específicos del modelo (lógica de negocio)
    /*public Ticket readTicket(Long ticketId) {
        // Lógica para leer un ticket de la base de datos
        // Implementa la lógica según tu base de datos y sistema de persistencia
        return null;
    }

    public void addTicket(Ticket ticket) {
        // Lógica para agregar un nuevo ticket a la base de datos
        // Implementa la lógica según tu base de datos y sistema de persistencia
    }

    public void closeTicket(Long ticketId) {
        // Lógica para cerrar un ticket en la base de datos
        // Implementa la lógica según tu base de datos y sistema de persistencia
    }*/
}