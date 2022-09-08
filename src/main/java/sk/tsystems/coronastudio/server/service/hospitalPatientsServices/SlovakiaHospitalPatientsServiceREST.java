package sk.tsystems.coronastudio.server.service.hospitalPatientsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.hospitalPatients.SlovakiaHospitalPatients;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class SlovakiaHospitalPatientsServiceREST implements SlovakiaHospitalPatientsService {

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;



    @Override
    public void addSlovakiaHospitalPatients(SlovakiaHospitalPatients slovakiaHospitalPatients) {
        restTemplate.postForEntity(url+"/slovakiaHospitalPatients", slovakiaHospitalPatients, SlovakiaHospitalPatients.class);
    }

    @Override
    public List<SlovakiaHospitalPatients> getSlovakiaHospitalPatients() {
        return Arrays.asList(restTemplate.getForEntity(url+"/slovakiaHospitalPatients/", SlovakiaHospitalPatients[].class).getBody());
    }

    @Override
    public void reset() {
        
    }

}
