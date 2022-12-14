package sk.tsystems.coronastudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.Hospitals;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

public class HospitalsServiceREST implements HospitalsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addHospital(Hospitals hospitals) {
        restTemplate.postForEntity(url+"/hospitals",hospitals, Hospitals.class);;
    }

    @Override
    public List<Hospitals> getHospitals(){
        return Arrays.asList(restTemplate.getForEntity(url+"/hospitals",Hospitals[].class).getBody());
    }


    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
