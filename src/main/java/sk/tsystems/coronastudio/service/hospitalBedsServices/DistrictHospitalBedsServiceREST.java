package sk.tsystems.coronastudio.service.hospitalBedsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.hospitalBeds.DistrictHospitalBeds;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class DistrictHospitalBedsServiceREST implements DistrictHospitalBedsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addDistHosBeds(DistrictHospitalBeds districtHospitalBeds) {
        restTemplate.postForEntity(url+"/districtHospitalBeds",districtHospitalBeds, DistrictHospitalBeds.class);
    }

    @Override
    public List<DistrictHospitalBeds> getDistHosBeds() {
        return Arrays.asList(restTemplate.getForEntity(url+"/districtHospitalBeds",DistrictHospitalBeds[].class).getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
