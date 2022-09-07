package sk.tsystems.coronastudio.service;

import sk.tsystems.coronastudio.entity.Cities;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CitiesServiceJPA implements CitiesService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addCity(Cities cities) {
        entityManager.persist(cities);
    }

    public List<Cities> getCities(){
        return entityManager.createQuery("select c from Cities c").getResultList();
    }


    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM cities").executeUpdate();
    }
}
