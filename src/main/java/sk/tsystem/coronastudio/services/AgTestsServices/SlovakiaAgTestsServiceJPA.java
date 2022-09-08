package sk.tsystem.coronastudio.services.AgTestsServices;

import sk.tsystem.coronastudio.entity.AgTests.SlovakiaAgTests;

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
}
