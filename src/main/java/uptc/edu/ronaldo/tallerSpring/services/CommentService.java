package uptc.edu.ronaldo.tallerSpring.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.edu.ronaldo.tallerSpring.entities.Comment;
import uptc.edu.ronaldo.tallerSpring.repositores.CommentRepository;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void updateComment(Long commentId, String newContent) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comentario no encontrado con el ID: " + commentId));
        comment.setContent(newContent);
        commentRepository.save(comment);
    }

    public List<Comment> readComments(Long ticketId) {
        return commentRepository.findByTicketId(ticketId);
    }

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}