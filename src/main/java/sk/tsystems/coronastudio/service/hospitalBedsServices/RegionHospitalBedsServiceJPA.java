package sk.tsystems.coronastudio.service.hospitalBedsServices;

import sk.tsystems.coronastudio.ObjectsDTO.RegFreeCovBedsDTO;
import sk.tsystems.coronastudio.entity.hospitalBeds.RegionHospitalBeds;
import sk.tsystems.coronastudio.entity.hospitalBeds.SlovakiaHospitalBeds;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RegionHospitalBedsServiceJPA implements RegionHospitalBedsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRegHosBeds(RegionHospitalBeds regionHospitalBeds) {
        entityManager.persist(regionHospitalBeds);
    }

    @Override
    public List<RegionHospitalBeds> getRegHosBeds() {
        return entityManager.createQuery("select r from RegionHospitalBeds r").getResultList();
    }

    @Override
    public List<RegFreeCovBedsDTO> getRegCovCapacity() {
        return entityManager.createNativeQuery("SELECT distinct on (title)title, capacity_covid  FROM (SELECT r.title as title, capacity_covid FROM region_hospital_beds inner join regions r on r.id = region_hospital_beds.regions_id order by newest_reported_at desc) as capacity")
                .getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM region_hospital_beds").executeUpdate();
    }
}
