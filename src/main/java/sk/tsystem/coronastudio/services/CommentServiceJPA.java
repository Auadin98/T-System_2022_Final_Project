package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.Comment;
import sk.tsystem.coronastudio.services.CommentService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class CommentServiceJPA implements CommentService{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addComment(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public List<Comment> getComment() {
        return entityManager.createQuery("select c from Comment c order by c.commentedon desc")
                .setMaxResults(5)
                .getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM comment ").executeUpdate();
    }
}
