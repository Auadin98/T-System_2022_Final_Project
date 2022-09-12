package coronastudio.service;

import sk.tsystems.coronastudio.entity.Districts;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DistrictsServiceJPA implements DistrictsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDistrict(Districts districts) {
        entityManager.persist(districts);
    }

    @Override
    public List<Districts> getDistricts() {
        return entityManager.createQuery("select d from Districts d").getResultList();
    }
    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM districts").executeUpdate();
    }
}
