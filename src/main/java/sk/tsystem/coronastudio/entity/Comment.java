package sk.tsystem.coronastudio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private long ident;
    private String username;
    @Column (length = 1000)
    private String comment;

    private Date commentedon;

    public Comment(String username, String comment, Date commentedon) {
        this.username = username;
        this.comment = comment;
        this.commentedon = commentedon;
    }
    public  Comment(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentedon() {
        return commentedon;
    }

    public void setCommentedon(Date commentedon) {
        this.commentedon = commentedon;
    }


}
