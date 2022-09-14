package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserServiceJPA implements UserService{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getUsersByName(String username) {
        return entityManager.createQuery("select u from User u where u.userName = :userName")
                .setParameter("userName", username)
                .getResultList();
    }
}
