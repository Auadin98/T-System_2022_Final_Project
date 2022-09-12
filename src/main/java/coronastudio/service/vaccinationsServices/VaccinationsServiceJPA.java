package coronastudio.service.vaccinationsServices;

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
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM vaccinations").executeUpdate();
    }
}
