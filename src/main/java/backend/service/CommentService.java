package backend.service;


import backend.entity.Bug;
import backend.entity.Comment;
import backend.entity.User;
import backend.repository.IBugRepository;
import backend.repository.ICommentRepository;
import backend.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private ICommentRepository ICommentRepository;
    private IBugRepository IBugRepository;
    private IUserRepository IUserRepository;

    public List<Comment> retrieveComments() {
        return (List<Comment>) this.ICommentRepository.findAll();
    }

    public Comment retrieveCommentById(Long id) {
        return this.ICommentRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Comment with id not found");
        });
    }

    @Transactional
    public Comment insertComment(Long bugId, Long userId, String text, String imageURL, String dateTime) {
        Bug bug = IBugRepository.findById(bugId).orElseThrow(() ->
                new IllegalArgumentException("Bug-ul cu ID-ul " + bugId + " nu există!"));
        User user = IUserRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("Utilizatorul cu ID-ul " + userId + " nu există!"));
        Comment comment = new Comment(text, imageURL, dateTime, user, bug);
        user.getComments().add(comment);
        bug.getComments().add(comment);
        return ICommentRepository.save(comment);
    }

    @Transactional
    public Comment updateComment(Comment updatedComment) {
        Comment existingComment = ICommentRepository.findById(updatedComment.getIdComment()).orElseThrow(() ->
                new IllegalArgumentException("Comentariul cu ID-ul " + updatedComment.getIdComment() + " nu există!"));
        existingComment.setText(updatedComment.getText());
        existingComment.setImageURL(updatedComment.getImageURL());
        existingComment.setDate(updatedComment.getDate());

        return ICommentRepository.save(existingComment);
    }

    @Transactional
    public String deleteById(Long id) {
        try {
            this.ICommentRepository.deleteById(id);
            return "Deletion Successfully";
        } catch (Exception e) {
            return "Failed to delete comment with id " + id;
        }
    }
}
