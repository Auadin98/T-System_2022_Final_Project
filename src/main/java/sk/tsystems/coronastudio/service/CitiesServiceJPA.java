package sk.tsystems.coronastudio.service;

import sk.tsystems.coronastudio.ObjectsDTO.ActualDataTestTDO;
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

    @Override
    public List<Cities> getCities(){
        return entityManager.createQuery("select c from Cities c").getResultList();
    }

    @Override
    public List<ActualDataTestTDO> getActualDataCities(){
        return entityManager.createNativeQuery("SELECT distinct on (title)title, id, free_all, confirmed_covid ,non_covid, suspected_covid FROM\n" +
                "(select c.id as id, c.title as title,hp.confirmed_covid as confirmed_covid, hb.free_all as free_all, hp.non_covid as non_covid, hp.suspected_covid as suspected_covid\n" +
                "FROM cities c\n" +
                "inner join hospitals h on c.id = h.cities_id\n" +
                "inner join  hospital_beds hb on h.id = hb.hospitals_id\n" +
                "inner join hospital_patients hp on h.id = hp.hospitals_id\n" +
                "order by hb.updated_at desc) as JanVozar").getResultList();
    }



    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM cities").executeUpdate();
    }
}
