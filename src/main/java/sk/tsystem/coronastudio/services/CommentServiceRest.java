package sk.tsystem.coronastudio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystem.coronastudio.entity.Comment;
import sk.tsystem.coronastudio.services.CommentService;

import java.util.Arrays;
import java.util.List;

public class CommentServiceRest implements CommentService{

    @Value("${remote.server.api}")
    private String url;

    @Autowired
    RestTemplate template;

    @Override
    public void addComment(Comment comment) {
        template.postForEntity(url+"/comments", comment, Comment.class);
    }


    @Override
    public List<Comment> getComment() {
        return Arrays.asList(template.getForEntity(url+"/comments/", Comment[].class).getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported");
    }

}
