package sk.tsystems.coronastudio.service.vaccinationsServices;

import sk.tsystems.coronastudio.entity.vaccinations.Vaccinations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class VaccinationsServiceJPA implements VaccinationsService{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addVaccinations(Vaccinations vaccinations) {
        entityManager.persist(vaccinations);
    }

    @Override
    public List<Vaccinations> getVaccinations() {
        return entityManager.createQuery("select v from Vaccinations v").getResultList();
    }

    @Override
    public int getDose1Sum() {
        return ((Number)entityManager.createQuery("select s.dose1_sum from SlovakiaVaccinations s order by s.updated_at desc")
                .setMaxResults(1)
                .getSingleResult()).intValue();
    }

    @Override
    public int getDose2Sum() {
        return ((Number)entityManager.createQuery("select s.dose2_sum from SlovakiaVaccinations s order by s.updated_at desc")
                .setMaxResults(1)
                .getSingleResult()).intValue();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM vaccinations").executeUpdate();
    }
}
