package coronastudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.Districts;

import java.util.Arrays;
import java.util.List;


public class DistrictsServiceREST implements DistrictsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addDistrict(Districts districts) {
        restTemplate.postForEntity(url+"/districts",districts,Districts.class);
    }

    @Override
    public List<Districts> getDistricts() {
        return Arrays.asList(restTemplate.getForEntity(url+"/districts", Districts[].class).getBody());
    }
    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
