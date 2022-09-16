package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.Comment;
import sk.tsystem.coronastudio.services.CommentService;


import java.util.List;

public interface CommentService {
    void addComment(Comment comment);

    List<Comment> getComment();

    void reset();
}
