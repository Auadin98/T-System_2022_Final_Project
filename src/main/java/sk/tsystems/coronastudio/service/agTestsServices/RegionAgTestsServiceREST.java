package sk.tsystems.coronastudio.service.agTestsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.ObjectsDTO.AgNegativeTestDTO;
import sk.tsystems.coronastudio.ObjectsDTO.AgPositiveTestDTO;
import sk.tsystems.coronastudio.entity.agTests.RegionAgTests;

import java.util.Arrays;
import java.util.List;

public class RegionAgTestsServiceREST implements RegionAgTestsService{
    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addRegAgTest(RegionAgTests regionAgTest) {
        restTemplate.postForEntity(url+"/regionAgTests", regionAgTest, RegionAgTests.class);
    }

    @Override
    public List<RegionAgTests> getRegAgTests() {
        return Arrays.asList(restTemplate.getForEntity(url+"/regionAgTests/", RegionAgTests[].class).getBody());
    }

    @Override
    public List<AgPositiveTestDTO> getPositiveAgTests() {
        return Arrays.asList(restTemplate.getForObject(url+"/PositiveAgTests/", AgPositiveTestDTO[].class));
    }

    @Override
    public List<AgNegativeTestDTO> getNegativeAgTests() {
        return Arrays.asList(restTemplate.getForObject(url+"/NegativeAgTests/", AgNegativeTestDTO[].class));
    }


    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
