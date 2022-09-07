package sk.tsystem.coronastudio.services;

import java.util.List;
import sk.tsystem.coronastudio.entity.HospitalStaff;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class HospitalStaffServiceJPA implements HospitalStaffService{
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
}
