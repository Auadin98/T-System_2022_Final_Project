package coronastudio.service.hospitalBedsServices;

import sk.tsystems.coronastudio.entity.hospitalBeds.RegionHospitalBeds;

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
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM region_hospital_beds").executeUpdate();
    }
}
