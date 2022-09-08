package sk.tsystem.coronastudio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystem.coronastudio.entity.Regions;

import java.util.Arrays;
import java.util.List;

public class RegionServiceREST implements RegionService{
    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addRegion(Regions region) {
        restTemplate.postForEntity(url+"/region", region, Regions.class);
    }

    @Override
    public List<Regions> getRegions() {
        return Arrays.asList(restTemplate.getForEntity(url+"/region/", Regions[].class).getBody());
    }
}
