package sk.tsystems.coronastudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.Regions;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

public class RegionsServiceREST implements RegionsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addRegion(Regions regions) {
        restTemplate.postForEntity(url+"/regions",regions, Regions.class);
    }

    @Override
    public List<Regions> getRegions() {
        return Arrays.asList(restTemplate.getForEntity(url+"/regions",Regions[].class).getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
