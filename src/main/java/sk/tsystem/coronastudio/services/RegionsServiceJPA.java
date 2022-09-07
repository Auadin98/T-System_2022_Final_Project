package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.Regions;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RegionsServiceJPA implements RegionService{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRegion(Regions region) {
        entityManager.persist(region);
    }

    @Override
    public List<Regions> getRegions() {
        return entityManager
                .createQuery("select r from Regions r")
                .getResultList();
    }
}
