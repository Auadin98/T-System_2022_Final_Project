package sk.tsystems.coronastudio.service.hospitalPatientsServices;

import sk.tsystems.coronastudio.ObjectsDTO.RegHosPatientsDTO;
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
    public List<RegHosPatientsDTO> getActualRegionHospitalPatients() {
        return entityManager.createNativeQuery("SELECT title, sumCovid FROM (SELECT updated_at, r2.title AS title, sum(r.confirmed_covid) AS sumCovid FROM region_hospital_patients r inner join regions r2 on r2.id = r.regions_id group by r2.title, updated_at order by updated_at limit 8) as covidPatients")
                .getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM region_hospital_patients").executeUpdate();
    }
}
