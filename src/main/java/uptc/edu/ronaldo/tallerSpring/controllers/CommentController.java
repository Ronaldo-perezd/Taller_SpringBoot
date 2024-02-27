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

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<Comment>> getCommentsByTicketId(@PathVariable Long ticketId) {
        List<Comment> comments = commentService.readComments(ticketId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping
    public ResponseEntity<Void> createComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}