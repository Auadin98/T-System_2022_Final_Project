package sk.tsystems.coronastudio.service.vaccinationsServices;

import sk.tsystems.coronastudio.entity.Vaccines;
import sk.tsystems.coronastudio.entity.vaccinations.SlovakiaVaccinations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SlovakiaVaccinationsServiceJPA implements SlovakiaVaccinationsService{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addSlovakiaVaccinations(SlovakiaVaccinations slovakiaVaccinations) {
        entityManager.persist(slovakiaVaccinations);
    }

    @Override
    public List<SlovakiaVaccinations> getSlovakiaVaccinations() {
        return entityManager.createQuery("select s from SlovakiaVaccinations s").getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM slovakia_vaccinations").executeUpdate();
    }
}
