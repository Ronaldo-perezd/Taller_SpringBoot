package uptc.edu.ronaldo.tallerSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uptc.edu.ronaldo.tallerSpring.entities.Comment;
import uptc.edu.ronaldo.tallerSpring.services.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateComment(@PathVariable Long id, @RequestBody String newContent) {
        commentService.updateComment(id, newContent);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/ticket/{ticketId}/comments")
    public ResponseEntity<Object> getCommentsByTicketId(@PathVariable Long ticketId) {
        List<Comment> comments = commentService.readComments(ticketId);
        if (comments.isEmpty()) {
            return ResponseEntity.ok().body("No hay comentarios para este ticket.");
        } else {
            return ResponseEntity.ok().body(comments);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}