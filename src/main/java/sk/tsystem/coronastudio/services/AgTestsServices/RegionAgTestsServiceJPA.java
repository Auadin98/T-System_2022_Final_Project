package sk.tsystem.coronastudio.services.AgTestsServices;

import sk.tsystem.coronastudio.entity.AgTests.RegionAgTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RegionAgTestsServiceJPA implements RegionAgTestsService{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRegAgTest(RegionAgTests regionAgTest) {
            entityManager.persist(regionAgTest);
    }

    @Override
    public List<RegionAgTests> getRegAgTests() {
        return entityManager
                .createQuery("select t from RegionAgTests t")
                .getResultList();
    }
}
