package sk.tsystem.coronastudio.services.AgTestsServices;

import sk.tsystem.coronastudio.entity.AgTests.AgTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class AgTestsServiceJPA implements AgTestsService{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addAgTest(AgTests agTest) {
        entityManager.persist(agTest);
    }

    @Override
    public List<AgTests> getAgTests() {
        return entityManager
                .createQuery("select t from AgTests t")
                .getResultList();
    }
}
