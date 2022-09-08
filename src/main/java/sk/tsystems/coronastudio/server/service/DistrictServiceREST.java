package sk.tsystems.coronastudio.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.Districts;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class DistrictServiceREST implements DistrictsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addDistrict(Districts district) {
        restTemplate.postForEntity(url+"/district", district, Districts.class);
    }

    @Override
    public List<Districts> getDistricts() {
        return Arrays.asList(restTemplate.getForEntity(url+"/district/", Districts[].class).getBody());
    }

    @Override
    public void reset() {
        
    }

}
