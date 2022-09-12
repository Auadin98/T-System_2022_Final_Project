package coronastudio.service;

import sk.tsystems.coronastudio.entity.Regions;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RegionsServiceJPA implements RegionsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRegion(Regions regions) {
        entityManager.persist(regions);
    }

    @Override
    public List<Regions> getRegions() {
        return entityManager.createQuery("select r from Regions r").getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM regions").executeUpdate();
    }
}
