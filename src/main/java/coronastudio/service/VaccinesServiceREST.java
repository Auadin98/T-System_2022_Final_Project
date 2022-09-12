package coronastudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.Vaccines;

import java.util.Arrays;
import java.util.List;

public class VaccinesServiceREST implements VaccinesService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addVaccine(Vaccines vaccines) {
        restTemplate.postForEntity(url+"/vaccines",vaccines, Vaccines.class);
    }

    @Override
    public List<Vaccines> getVaccines() {
        return Arrays.asList(restTemplate.getForEntity(url+"/vaccines",Vaccines[].class).getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
