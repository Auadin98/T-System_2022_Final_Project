package sk.tsystems.coronastudio.service.hospitalBedsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.hospitalBeds.HospitalBeds;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

public class HospitalBedsServiceREST implements HospitalBedsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addHosBeds(HospitalBeds hospitalBeds) {
        restTemplate.postForEntity(url+"/hospitalBeds",hospitalBeds, HospitalBeds.class);
    }

    @Override
    public List<HospitalBeds> getHosBeds() {
        return Arrays.asList(restTemplate.getForEntity(url+"/hospitalBeds",HospitalBeds[].class).getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
