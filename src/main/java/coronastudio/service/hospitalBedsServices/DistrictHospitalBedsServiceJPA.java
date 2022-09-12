package coronastudio.service.hospitalBedsServices;

import sk.tsystems.coronastudio.entity.hospitalBeds.DistrictHospitalBeds;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DistrictHospitalBedsServiceJPA implements DistrictHospitalBedsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDistHosBeds(DistrictHospitalBeds districtHospitalBeds) {
        entityManager.persist(districtHospitalBeds);
    }

    @Override
    public List<DistrictHospitalBeds> getDistHosBeds() {
        return entityManager.createQuery("select d from DistrictHospitalBeds d").getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM district_hospital_beds").executeUpdate();
    }
}
