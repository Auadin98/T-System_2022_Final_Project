package sk.tsystems.coronastudio.service.vaccinationsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.vaccinations.VaccinationContacts;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

public class VaccinationContactsServiceREST implements VaccinationContactsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public void addVaccinationContacts(VaccinationContacts vaccinationContacts) {
        restTemplate.postForEntity(url+"/vaccinationContacts",vaccinationContacts, VaccinationContacts.class);
    }

    @Override
    public List<VaccinationContacts> getVaccinationContacts() {
        return Arrays.asList(restTemplate.getForEntity(url+"/vaccinationContacts",VaccinationContacts[].class).getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
