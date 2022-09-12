package coronastudio.service.hospitalPatientsServices;

import sk.tsystems.coronastudio.entity.hospitalPatients.DistrictHospitalPatients;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DistrictHospitalPatientsServiceJPA implements DistrictHospitalPatientsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDistrictHospitalPatients(DistrictHospitalPatients districtHospitalPatients) {
        entityManager.persist(districtHospitalPatients);
    }

    @Override
    public List<DistrictHospitalPatients> getDistrictHospitalPatients() {
        return entityManager.createQuery("select d from DistrictHospitalPatients d").getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM district_hospital_patients").executeUpdate();
    }
}
