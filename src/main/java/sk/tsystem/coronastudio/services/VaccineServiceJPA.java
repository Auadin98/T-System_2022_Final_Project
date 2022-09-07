package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.Vaccines;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class VaccineServiceJPA implements VaccineService{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addVaccine(Vaccines vaccine) {
        entityManager.persist(vaccine);
    }

    @Override
    public List<Vaccines> getVaccines() {
        return entityManager
                .createQuery("select v from Vacciens v")
                .getResultList();
    }
}
