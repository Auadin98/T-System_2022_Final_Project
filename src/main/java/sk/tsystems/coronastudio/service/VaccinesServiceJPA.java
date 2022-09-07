package sk.tsystems.coronastudio.service;

import sk.tsystems.coronastudio.entity.Vaccines;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class VaccinesServiceJPA implements VaccinesService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addVaccine(Vaccines vaccines) {
        entityManager.persist(vaccines);
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM vaccines").executeUpdate();
    }
}
