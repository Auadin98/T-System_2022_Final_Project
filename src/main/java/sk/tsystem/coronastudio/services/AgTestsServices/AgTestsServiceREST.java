package sk.tsystem.coronastudio.services.AgTestsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystem.coronastudio.entity.AgTests.AgTests;

import java.util.List;
import java.util.Arrays;

public class AgTestsServiceREST implements AgTestsService{
    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addAgTest(AgTests agTest) {
        restTemplate.postForEntity(url+"/agTests", agTest, AgTests.class);
    }

    @Override
    public List<AgTests> getAgTests() {
        return Arrays.asList(restTemplate.getForEntity(url+"/agTests/", AgTests[].class).getBody());
    }
}
