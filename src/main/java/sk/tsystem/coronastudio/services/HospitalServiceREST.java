package sk.tsystem.coronastudio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystem.coronastudio.entity.Districts;
import sk.tsystem.coronastudio.entity.Hospitals;

import java.util.Arrays;
import java.util.List;

public class HospitalServiceREST implements HospitalService{
    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addHospital(Hospitals hospital) {
        restTemplate.postForEntity(url+"/hospital", hospital, Hospitals.class);
    }

    @Override
    public List<Hospitals> getHospitals() {
        return Arrays.asList(restTemplate.getForEntity(url+"/hospital/", Hospitals[].class).getBody());
    }
}
