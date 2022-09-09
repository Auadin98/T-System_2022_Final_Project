package sk.tsystems.coronastudio.service.agTestsServices;

import sk.tsystems.coronastudio.entity.agTests.DistrictAgTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DistrictAgTestsServiceJPA implements DistrictAgTestsService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDisAgTest(DistrictAgTests districtAgTest) {
        entityManager.persist(districtAgTest);
    }

    @Override
    public List<DistrictAgTests> getDisAgTests() {
        return entityManager
                .createQuery("select t from DistrictAgTests t")
                .getResultList();
    }

    @Override
    public void reset(){
        entityManager.createNativeQuery("DELETE FROM district_ag_tests").executeUpdate();
    }
}

