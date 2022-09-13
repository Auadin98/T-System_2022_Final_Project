package sk.tsystems.coronastudio.service.hospitalPatientsServices;

import sk.tsystems.coronastudio.entity.hospitalPatients.RegionHospitalPatients;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
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
