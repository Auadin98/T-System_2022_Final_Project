package sk.tsystems.coronastudio.service.hospitalPatientsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.hospitalPatients.DistrictHospitalPatients;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class DistrictHospitalPatientsServiceREST implements DistrictHospitalPatientsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addDistrictHospitalPatients(DistrictHospitalPatients districtHospitalPatients) {
        restTemplate.postForEntity(url+"/districtHospitalPatients",districtHospitalPatients, DistrictHospitalPatients.class);
    }

    @Override
    public List<DistrictHospitalPatients> getDistrictHospitalPatients() {
        return Arrays.asList(restTemplate.getForEntity(url+"/districtHospitalPatients",DistrictHospitalPatients[].class)
                .getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
