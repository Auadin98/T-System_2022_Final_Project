package coronastudio.service.agTestsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.agTests.DistrictAgTests;

import java.util.Arrays;
import java.util.List;

public class DistrictAgTestsServiceREST implements DistrictAgTestsService{
    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addDisAgTest(DistrictAgTests districtAgTest) {
        restTemplate.postForEntity(url+"/districtAgTests", districtAgTest, DistrictAgTests.class);
    }

    @Override
    public List<DistrictAgTests> getDisAgTests() {
        return Arrays.asList(restTemplate.getForEntity(url+"/districtAgTests/", DistrictAgTests[].class).getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
