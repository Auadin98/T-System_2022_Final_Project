package sk.tsystems.coronastudio.server.service.hospitalPatientsServices;

import sk.tsystems.coronastudio.entity.hospitalPatients.RegionHospitalPatients;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RegionHospitalPatientsServiceJPA implements RegionHospitalPatientsService{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addRegionHospitalPatients(RegionHospitalPatients regionHospitalPatients) {
        entityManager.persist(regionHospitalPatients);
    }

    @Override
    public List<RegionHospitalPatients> getRegionHospitalPatients() {
        return entityManager.createQuery("select r from RegionHospitalPatients r").getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM region_hospital_patients").executeUpdate();
    }
}
