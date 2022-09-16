package sk.tsystems.coronastudio.service.agTestsServices;

import sk.tsystems.coronastudio.ObjectsDTO.AgNegativeTestDTO;
import sk.tsystems.coronastudio.ObjectsDTO.AgPositiveTestDTO;
import sk.tsystems.coronastudio.entity.agTests.RegionAgTests;

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

    @Override
    public List<AgPositiveTestDTO> getPositiveAgTests() {
        List<AgPositiveTestDTO> resultList = entityManager.createNativeQuery("SELECT r2.title, sum(r.positives_sum) AS test FROM region_ag_tests r inner join regions r2 on r2.id = r.regions_id GROUP BY regions_id, r2.title")
                .getResultList();
        return resultList;
    }

    @Override
    public List<AgNegativeTestDTO> getNegativeAgTests() {
        List<AgNegativeTestDTO> resultList = entityManager.createNativeQuery("SELECT r2.title, sum(r.negatives_sum) AS test FROM region_ag_tests r inner join regions r2 on r2.id = r.regions_id GROUP BY regions_id, r2.title")
                .getResultList();
        return resultList;
    }


    @Override
    public void reset(){
        entityManager.createNativeQuery("DELETE FROM region_ag_tests").executeUpdate();
    }
}
