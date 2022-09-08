package sk.tsystems.coronastudio.service.hospitalBedsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.hospitalBeds.SlovakiaHospitalBeds;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class SlovakiaHospitalBedsServiceREST implements SlovakiaHospitalBedsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addSlovHosBeds(SlovakiaHospitalBeds slovakiaHospitalBeds) {
        restTemplate.postForEntity(url+"/slovakiaHospitalBeds",slovakiaHospitalBeds, SlovakiaHospitalBeds.class);
    }

    @Override
    public List<SlovakiaHospitalBeds> getSlovHosBeds() {
        return Arrays.asList(restTemplate.getForEntity(url+"/slovakiaHospitalBeds",SlovakiaHospitalBeds[].class).getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
