package sk.tsystems.coronastudio.service.userServices;


import sk.tsystems.coronastudio.entity.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);

    List<Comment> getComment();

    void reset();
}
