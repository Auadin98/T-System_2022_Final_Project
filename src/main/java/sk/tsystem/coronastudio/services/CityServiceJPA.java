package sk.tsystem.coronastudio.services;



import sk.tsystem.coronastudio.entity.City;
import sk.tsystem.coronastudio.entity.Hospital;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class CityServiceJPA implements CityService{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<City> getCities() {
        return entityManager.createQuery("select c from Hospital c").
                getResultList();
    }



    @Override
    public void addCity(City city) {
                   entityManager.persist(city);
    }
}
