package sk.tsystem.coronastudio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystem.coronastudio.entity.Cities;
import sk.tsystem.coronastudio.entity.Districts;

import java.util.Arrays;
import java.util.List;

public class DistrictServiceREST implements DistrictService{
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
}
