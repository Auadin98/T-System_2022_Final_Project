package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.Hospitals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HospitalServiceJPA implements HospitalService{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospital(Hospitals hospital) {
        entityManager.persist(hospital);
    }

    @Override
    public List<Hospitals> getHospitals() {
        return entityManager
                .createQuery("select h from Hospitals h")
                .getResultList();
    }
}
