package sk.tsystem.coronastudio.services;



import sk.tsystem.coronastudio.entity.Hospital;
import sk.tsystem.coronastudio.entity.Region;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class RegionServiceJPA implements RegionService {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Region> getRegions() {
        return entityManager.createQuery("select r from Region r").
                getResultList();
    }

    @Override
    public void addRegion(Region region) {
        Region regionWrite = null;
        try {
            regionWrite = (Region) entityManager
                    .createQuery("select r from Region r where r.region = :myRegion and r.id = :myId and r.abbreviation = :myAbbreviation and r.code = :myCode")
                    .setParameter("myRegion", region.getRegion())
                    .setParameter("myId", region.getId())
                    .setParameter("myAbbreviation", region.getAbbreviation())
                    .setParameter("myCode", region.getCode())
                    .getSingleResult();
            regionWrite.setRegion(region.getRegion());
            regionWrite.setRegion(String.valueOf(region.getId()));
            regionWrite.setRegion(region.getAbbreviation());
            regionWrite.setRegion(region.getCode());

        } catch (NoResultException e) {
            entityManager.persist(region);
        }


    }
}
