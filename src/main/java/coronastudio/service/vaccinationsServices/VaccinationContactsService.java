package coronastudio.service.vaccinationsServices;



import sk.tsystems.coronastudio.entity.vaccinations.VaccinationContacts;

import java.util.List;

public interface VaccinationContactsService {

    public void addVaccinationContacts(VaccinationContacts vaccinationContacts);

    public List<VaccinationContacts> getVaccinationContacts();

    public void reset();
}
