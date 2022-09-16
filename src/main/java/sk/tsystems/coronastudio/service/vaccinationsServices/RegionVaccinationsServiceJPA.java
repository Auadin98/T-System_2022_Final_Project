package sk.tsystems.coronastudio.service.vaccinationsServices;

import sk.tsystems.coronastudio.ObjectsDTO.VaccinationsRegDTO;
import sk.tsystems.coronastudio.entity.vaccinations.RegionVaccinations;
import sk.tsystems.coronastudio.entity.vaccinations.SlovakiaVaccinations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RegionVaccinationsServiceJPA implements RegionVaccinationsService{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addRegionVaccinations(RegionVaccinations regionVaccinations) {
        entityManager.persist(regionVaccinations);
    }

    @Override
    public List<RegionVaccinations> getRegionVaccinations() {
        return entityManager.createQuery("select r from RegionVaccinations r").getResultList();
    }

    @Override
    public List<VaccinationsRegDTO> getRegDoseVacc() {
        return entityManager.createNativeQuery("SELECT r.title, sum(dose1_sum) AS dose1, sum(dose2_sum) AS dose2 FROM region_vaccinations inner join regions r on r.id = region_vaccinations.regions_id group by r.title")
                .getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM region_vaccinations").executeUpdate();
    }
}
