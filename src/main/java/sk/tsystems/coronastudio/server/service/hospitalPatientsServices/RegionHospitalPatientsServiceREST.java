package sk.tsystems.coronastudio.server.service.hospitalPatientsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.hospitalPatients.RegionHospitalPatients;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class RegionHospitalPatientsServiceREST implements RegionHospitalPatientsService {

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addRegionHospitalPatients(RegionHospitalPatients regionHospitalPatients) {
        restTemplate.postForEntity(url+"/regionHospitalPatients", regionHospitalPatients, RegionHospitalPatients.class);

    }

    @Override
    public List<RegionHospitalPatients> getRegionHospitalPatients() {
        return Arrays.asList(restTemplate.getForEntity(url+"/regionHospitalPatients/", RegionHospitalPatients[].class).getBody());

    }

    @Override
    public void reset() {
        
    }

}
