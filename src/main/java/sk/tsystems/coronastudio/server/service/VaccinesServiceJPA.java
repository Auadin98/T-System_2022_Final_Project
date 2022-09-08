package sk.tsystems.coronastudio.server.service;

import sk.tsystems.coronastudio.entity.Vaccines;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class VaccinesServiceJPA implements VaccinesService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addVaccine(Vaccines vaccines) {
        entityManager.persist(vaccines);
    }

    @Override
    public List<Vaccines> getVaccines() {
        return entityManager.createQuery("select r from Vaccines r").getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM vaccines").executeUpdate();
    }
}
