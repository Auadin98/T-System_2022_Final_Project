package sk.tsystems.coronastudio.service.hospitalBedsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.ObjectsDTO.RegFreeCovBedsDTO;
import sk.tsystems.coronastudio.entity.hospitalBeds.RegionHospitalBeds;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

public class RegionHospitalBedsServiceREST implements RegionHospitalBedsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addRegHosBeds(RegionHospitalBeds regionHospitalBeds) {
        restTemplate.postForEntity(url+"/regionHospitalBeds",regionHospitalBeds, RegionHospitalBeds.class);
    }

    @Override
    public List<RegionHospitalBeds> getRegHosBeds() {
        return Arrays.asList(restTemplate.getForEntity(url+"/regionHospitalBeds",RegionHospitalBeds[].class).getBody());
    }

    @Override
    public List<RegFreeCovBedsDTO> getRegCovCapacity() {
        return Arrays.asList(restTemplate.getForObject(url+"/regCovCapacity",RegFreeCovBedsDTO[].class));
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
