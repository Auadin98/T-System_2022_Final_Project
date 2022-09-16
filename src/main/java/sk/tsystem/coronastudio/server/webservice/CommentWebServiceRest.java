package sk.tsystem.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystem.coronastudio.entity.Comment;
import sk.tsystem.coronastudio.services.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentWebServiceRest {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getBestComment() {
        return commentService.getComment();
    }

    @PostMapping
    public void addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
    }

}
