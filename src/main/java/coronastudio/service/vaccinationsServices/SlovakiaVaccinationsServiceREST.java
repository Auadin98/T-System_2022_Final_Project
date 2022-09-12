package coronastudio.service.vaccinationsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.vaccinations.SlovakiaVaccinations;

import java.util.Arrays;
import java.util.List;

public class SlovakiaVaccinationsServiceREST implements SlovakiaVaccinationsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public void addSlovakiaVaccinations(SlovakiaVaccinations slovakiaVaccinations) {
        restTemplate.postForEntity(url+"/slovakiaVaccinations",slovakiaVaccinations, SlovakiaVaccinations.class);
    }

    @Override
    public List<SlovakiaVaccinations> getSlovakiaVaccinations() {
        return Arrays.asList(restTemplate.getForEntity(url+"/slovakiaVaccinations",SlovakiaVaccinations[].class).getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
