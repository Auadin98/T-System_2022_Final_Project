package sk.tsystem.coronastudio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystem.coronastudio.entity.Regions;
import sk.tsystem.coronastudio.entity.Vaccines;

import java.util.Arrays;
import java.util.List;

public class VaccineServiceREST implements VaccineService{
    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addVaccine(Vaccines vaccine) {
        restTemplate.postForEntity(url+"/vaccine", vaccine, Vaccines.class);
    }

    @Override
    public List<Vaccines> getVaccines() {
        return Arrays.asList(restTemplate.getForEntity(url+"/vaccine/", Vaccines[].class).getBody());
    }
}
