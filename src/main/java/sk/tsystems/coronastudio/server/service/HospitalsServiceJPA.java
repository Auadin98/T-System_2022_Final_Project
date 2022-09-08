package sk.tsystems.coronastudio.server.service;

import sk.tsystems.coronastudio.entity.Hospitals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HospitalsServiceJPA implements HospitalsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospital(Hospitals hospitals) {
        entityManager.persist(hospitals);
    }

    public List<Hospitals> getHospitals(){
        return entityManager.createQuery("select h from Hospitals h").getResultList();
    }


    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM hospitals").executeUpdate();
    }
}
