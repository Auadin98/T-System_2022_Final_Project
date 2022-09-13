package sk.tsystems.coronastudio.service.hospitalPatientsServices;

import sk.tsystems.coronastudio.entity.hospitalPatients.HospitalPatients;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HospitalPatientsServiceJPA implements HospitalPatientsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospitalPatients(HospitalPatients hospitalPatients) {
        entityManager.persist(hospitalPatients);
    }

    @Override
    public List<HospitalPatients> getHospitalPatients() {
        return entityManager.createQuery("select h from HospitalPatients h").getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM hospital_patients").executeUpdate();
    }
}
