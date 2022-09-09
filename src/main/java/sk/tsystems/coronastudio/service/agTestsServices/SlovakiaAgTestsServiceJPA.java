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
    public void reset(){
        entityManager.createNativeQuery("DELETE FROM slovakia_ag_tests").executeUpdate();
    }
}
