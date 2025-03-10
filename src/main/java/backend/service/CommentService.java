package backend.service;


import backend.entity.Bug;
import backend.entity.Comment;
import backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> retrieveComments() {
        return (List<Comment>) this.commentRepository.findAll();
    }

    public Comment retrieveCommentById(Long id) {
        return this.commentRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Comment with id not found");
        });
    }

    public Comment insertComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    public String deleteById(Long id) {
        try {
            this.commentRepository.deleteById(id);
            return "Deletion Successfully";
        } catch (Exception e) {
            return "Failed to delete comment with id " + id;
        }
    }
}
