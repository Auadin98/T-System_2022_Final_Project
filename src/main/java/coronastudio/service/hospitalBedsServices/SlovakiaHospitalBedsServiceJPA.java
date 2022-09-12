package coronastudio.service.hospitalBedsServices;

import sk.tsystems.coronastudio.entity.hospitalBeds.SlovakiaHospitalBeds;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SlovakiaHospitalBedsServiceJPA implements SlovakiaHospitalBedsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSlovHosBeds(SlovakiaHospitalBeds slovakiaHospitalBeds) {
        entityManager.persist(slovakiaHospitalBeds);
    }

    @Override
    public List<SlovakiaHospitalBeds> getSlovHosBeds() {
        return entityManager.createQuery("select s from SlovakiaHospitalBeds s").getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM slovakia_hospital_beds").executeUpdate();
    }
}
