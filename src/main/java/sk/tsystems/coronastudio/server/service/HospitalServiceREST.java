package sk.tsystems.coronastudio.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.Districts;
import sk.tsystems.coronastudio.entity.Hospitals;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class HospitalServiceREST implements HospitalsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public void addHospital(Hospitals hospitals) {
        restTemplate.postForEntity(url+"/hospitals", hospitals, Districts.class);
    }

    @Override
    public List<Hospitals> getHospitals() {
        return Arrays.asList(restTemplate.getForEntity(url+"/hospitals/", Hospitals[].class).getBody());
    }

    @Override
    public void reset() {
        
    }

}
