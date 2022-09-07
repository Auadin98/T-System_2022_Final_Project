package sk.tsystem.coronastudio.services;



import sk.tsystem.coronastudio.entity.Hospital;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class HospitalServiceJPA implements HospitalService{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Hospital> getHospitals() {
        return entityManager.createQuery("select c from Hospital c").
                getResultList();
    }

    @Override
    public void addHospital(Hospital hospital) {
                   entityManager.persist(hospital);
    }
}
