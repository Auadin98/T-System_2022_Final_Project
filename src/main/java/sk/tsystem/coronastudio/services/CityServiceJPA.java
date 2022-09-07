package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.Cities;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CityServiceJPA implements CityService{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addCity(Cities city) {
        entityManager.persist(city);
    }

    @Override
    public List<Cities> getCities() {
        return entityManager
                .createQuery("select c from Cities c")
                .getResultList();
    }
}
