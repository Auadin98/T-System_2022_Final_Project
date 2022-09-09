package sk.tsystems.coronastudio.service.vaccinationsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.vaccinations.RegionVaccinations;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
public class RegionVaccinationsServiceREST implements RegionVaccinationsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public void addRegionVaccinations(RegionVaccinations regionVaccinations) {
        restTemplate.postForEntity(url+"/regionVaccinations",regionVaccinations, RegionVaccinations.class);
    }

    @Override
    public List<RegionVaccinations> getRegionVaccinations() {
        return Arrays.asList(restTemplate.getForEntity(url+"/regionVaccinations",RegionVaccinations[].class).getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
