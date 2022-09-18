package sk.tsystems.coronastudio.service.agTestsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.agTests.SlovakiaAgTests;

import java.util.Arrays;
import java.util.List;

public class SlovakiaAgTestsServiceREST implements SlovakiaAgTestsService{
    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addSlovAgTest(SlovakiaAgTests slovakiaAgTest) {
        restTemplate.postForEntity(url+"/slovakiaAgTests", slovakiaAgTest, SlovakiaAgTests.class);
    }

    @Override
    public List<SlovakiaAgTests> getSlovAgTests() {
        return Arrays.asList(restTemplate.getForEntity(url+"/slovakiaAgTests/", SlovakiaAgTests[].class).getBody());
    }

    @Override
    public List<SlovakiaAgTests> getSumSlovAgTests() {
        return Arrays.asList(restTemplate.getForEntity(url+"/slovakiaSumAgTests/",SlovakiaAgTests[].class).getBody());
    }

    @Override
    public List<SlovakiaAgTests> getAvgPosRate() {
        return Arrays.asList(restTemplate.getForEntity(url+"/AvgPosRate/",SlovakiaAgTests[].class).getBody());
    }

    @Override
    public int getPosCount() {
        throw new UnsupportedOperationException("Not supported via web.");
    }

    @Override
    public int getPosSum() {
        throw new UnsupportedOperationException("Not supported via web.");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
