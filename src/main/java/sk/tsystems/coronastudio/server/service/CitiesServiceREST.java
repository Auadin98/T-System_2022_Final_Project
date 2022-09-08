package sk.tsystems.coronastudio.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.Cities;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class CitiesServiceREST implements CitiesService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addCity(Cities city) {
        restTemplate.postForEntity(url+"/city", city, Cities.class);
    }

    @Override
    public List<Cities> getCities() {
        return Arrays.asList(restTemplate.getForEntity(url+"/city/", Cities[].class).getBody());
    }

    @Override
    public void reset() {

    }

}
