package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.Districts;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DistrictServiceJPA implements DistrictService{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDistrict(Districts district) {
        entityManager.persist(district);
    }

    @Override
    public List<Districts> getDistricts() {
        return entityManager
                .createQuery("select d from Districts d")
                .getResultList();
    }
}
