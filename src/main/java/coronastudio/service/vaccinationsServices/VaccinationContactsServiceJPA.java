package coronastudio.service.vaccinationsServices;

import sk.tsystems.coronastudio.entity.vaccinations.VaccinationContacts;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class VaccinationContactsServiceJPA implements VaccinationContactsService{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addVaccinationContacts(VaccinationContacts vaccinationContacts) {
        entityManager.persist(vaccinationContacts);
    }

    @Override
    public List<VaccinationContacts> getVaccinationContacts() {
        return entityManager.createQuery("select v from VaccinationContacts v").getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM vaccination_contacts").executeUpdate();
    }
}
