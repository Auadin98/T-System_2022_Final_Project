package sk.tsystems.coronastudio.service.vaccinationsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.vaccinations.Vaccinations;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


public class VaccinationsServiceREST implements VaccinationsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addVaccinations(Vaccinations vaccinations) {
        restTemplate.postForEntity(url+"/vaccinations",vaccinations, Vaccinations.class);
    }

    @Override
    public List<Vaccinations> getVaccinations() {
        return Arrays.asList(restTemplate.getForEntity(url+"/vaccinations",Vaccinations[].class).getBody());
    }

    @Override
    public int getDose1Sum() {
        throw new UnsupportedOperationException("Not supported via web.");
    }

    @Override
    public int getDose2Sum() {
        throw new UnsupportedOperationException("Not supported via web.");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
