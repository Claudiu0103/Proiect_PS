package backend.controller;

import backend.entity.Bug;
import backend.entity.Comment;
import backend.entity.User;
import backend.service.BugService;
import backend.service.CommentService;
import backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<Comment> getAllComments() {
        return this.commentService.retrieveComments();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Comment getCommentById(@PathVariable Long id) {
        return this.commentService.retrieveCommentById(id);
    }

    @PostMapping("/addComment")
    @ResponseBody
    public Comment addComment(@RequestBody Comment comment) {
        return this.commentService.insertComment(comment);
    }

    @PutMapping("/updateComment")
    @ResponseBody
    public Comment updateComment(@RequestBody Comment comment) {
        return this.commentService.insertComment(comment);
    }

    @DeleteMapping("/deleteById")
    @ResponseBody
    public String deleteCommentById(@RequestParam Long id) {
        return this.commentService.deleteById(id);
    }
}
