package sk.tsystems.coronastudio.service.agTestsServices;

import sk.tsystems.coronastudio.entity.agTests.SlovakiaAgTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SlovakiaAgTestsServiceJPA  implements SlovakiaAgTestsService{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSlovAgTest(SlovakiaAgTests slovakiaAgTest) {
        entityManager.persist(slovakiaAgTest);
    }

    @Override
    public List<SlovakiaAgTests> getSlovAgTests() {
        return entityManager
                .createQuery("select t from SlovakiaAgTests t")
                .getResultList();
    }

    @Override
    public List<SlovakiaAgTests> getSumSlovAgTests() {
        return entityManager.createNativeQuery("SELECT negatives_sum, positives_sum FROM slovakia_ag_tests limit 1")
                .getResultList();
    }

    @Override
    public List<SlovakiaAgTests> getAvgPosRate() {
        return entityManager.createNativeQuery("SELECT EXTRACT(year from published_on) as year, EXTRACT(month from published_on) as month, avg(positivity_rate)FROM slovakia_ag_tests group by year, month order by year desc ,month desc limit 24")
                .getResultList();
    }

    @Override
    public void reset(){
        entityManager.createNativeQuery("DELETE FROM slovakia_ag_tests").executeUpdate();
    }
}
