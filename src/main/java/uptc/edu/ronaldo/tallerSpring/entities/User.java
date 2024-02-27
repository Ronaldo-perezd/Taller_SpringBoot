package uptc.edu.ronaldo.tallerSpring.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    @OneToMany(mappedBy = "assignedUser", cascade = CascadeType.ALL)
    private List<Ticket> assignedTickets;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Comment> comments;

    // Constructores, getters y setters

    public User() {
        // Constructor vacío necesario para JPA
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /* Métodos específicos del modelo (lógica de negocio)
    public List<User> readUsers() {
        // Lógica para leer todos los usuarios de la base de datos
        // Implementa la lógica según tu base de datos y sistema de persistencia
        return null;
    }

    public void addUser(User user) {
        // Lógica para agregar un nuevo usuario a la base de datos
        // Implementa la lógica según tu base de datos y sistema de persistencia
    }*/
}
