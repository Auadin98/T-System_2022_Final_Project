package sk.tsystems.coronastudio.server.service.hospitalPatientsServices;

import sk.tsystems.coronastudio.entity.hospitalPatients.SlovakiaHospitalPatients;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class SlovakiaHospitalPatientsServiceJPA implements SlovakiaHospitalPatientsService{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addSlovakiaHospitalPatients(SlovakiaHospitalPatients slovakiaHospitalPatients) {
        entityManager.persist(slovakiaHospitalPatients);
    }

    @Override
    public List<SlovakiaHospitalPatients> getSlovakiaHospitalPatients() {
        return entityManager.createQuery("select r from SlovakiaHospitalPatients r").getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM slovakia_hospital_patients").executeUpdate();
    }


}
