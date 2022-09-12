package coronastudio.service.hospitalStaffServices;

import sk.tsystems.coronastudio.entity.hospitalStaff.HospitalStaff;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class HospitalStaffServiceJPA implements HospitalStaffService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospitalStaff(HospitalStaff hospitalStaff) {
        entityManager.persist(hospitalStaff);
    }

    @Override
    public List<HospitalStaff> getHospitalStaff() {
        return entityManager
                .createQuery("select s from HospitalStaff s")
                .getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM hospital_staff").executeUpdate();
    }
}

