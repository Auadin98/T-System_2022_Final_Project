package sk.tsystems.coronastudio.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.Vaccines;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class VaccinesServiceREST implements VaccinesService{

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

    @Override
    public void reset() {
        
    }

}
