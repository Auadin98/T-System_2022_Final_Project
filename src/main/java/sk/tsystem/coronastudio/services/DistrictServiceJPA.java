package sk.tsystem.coronastudio.services;



import sk.tsystem.coronastudio.entity.District;
import sk.tsystem.coronastudio.entity.Region;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class DistrictServiceJPA implements DistrictService {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<District> getDistrict() {
        return entityManager.createQuery("select d from District d").
                getResultList();
    }

    @Override
    public void addDistricts(District district) {
        District districtWrite = null;
        try {
            districtWrite = (District) entityManager
                    .createQuery("select r from District r where r.district = :myDistrict and r.id = :myId and r.code = :myCode and r.region = :myRegion")
                    .setParameter("myDistrict", district.getDistrict())
                    .setParameter("myId", district.getId())
                    .setParameter("myCode", district.getCode())
                    .setParameter("myRegion",district.getRegion())
                    .getSingleResult();
            districtWrite.setDistrict(district.getDistrict());
            districtWrite.setDistrict(String.valueOf(district.getId()));
            districtWrite.setDistrict(district.getCode());
            districtWrite.setDistrict(district.getRegion());

        } catch (NoResultException e) {
            entityManager.persist(district);
        }

    }
}
