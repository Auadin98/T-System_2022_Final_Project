package sk.tsystems.coronastudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.ObjectsDTO.ActualDataTestTDO;
import sk.tsystems.coronastudio.entity.Cities;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CitiesServiceREST implements CitiesService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addCity(Cities cities) {
        restTemplate.postForEntity(url+"/cities/",cities,Cities.class);
    }

    @Override
    public List<Cities> getCities(){
        return Arrays.asList(restTemplate.getForEntity(url+"/cities/",Cities[].class).getBody());
    }

    @Override
    public List<Map<String, Object>> getActualDataCities() {
        throw new UnsupportedOperationException("Not supported via web.");
    }


    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
