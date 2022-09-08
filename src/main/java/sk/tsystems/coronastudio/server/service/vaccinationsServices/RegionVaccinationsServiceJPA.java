package sk.tsystems.coronastudio.server.service.vaccinationsServices;

import sk.tsystems.coronastudio.entity.vaccinations.RegionVaccinations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RegionVaccinationsServiceJPA implements RegionVaccinationsService{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addRegionVaccinations(RegionVaccinations regionVaccinations) {
        entityManager.persist(regionVaccinations);
    }

    @Override
    public List<RegionVaccinations> getRegionVaccinations() {
        return entityManager.createQuery("select r from RegionVaccinations r").getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM region_vaccinations").executeUpdate();
    }
}
