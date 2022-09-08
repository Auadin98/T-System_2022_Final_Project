package sk.tsystems.coronastudio.server.service.hospitalBedsServices;

import sk.tsystems.coronastudio.entity.hospitalBeds.HospitalBeds;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HospitalBedsServiceJPA implements HospitalBedsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHosBeds(HospitalBeds hospitalBeds) {
        entityManager.persist(hospitalBeds);
    }

    @Override
    public List<HospitalBeds> getHosBeds() {
        return entityManager.createQuery("select h from HospitalBeds h").getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM hospital_beds").executeUpdate();
    }
}
