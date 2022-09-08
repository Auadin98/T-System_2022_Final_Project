package sk.tsystems.coronastudio.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.Regions;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class RegionServiceREST implements RegionsService{

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
    @Override
    public void reset() {
        
    }

}
