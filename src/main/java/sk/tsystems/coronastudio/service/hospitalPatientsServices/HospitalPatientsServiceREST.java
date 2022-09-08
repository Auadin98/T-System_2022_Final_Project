package sk.tsystems.coronastudio.service.hospitalPatientsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.hospitalPatients.HospitalPatients;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
public class HospitalPatientsServiceREST implements HospitalPatientsService{

    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addHospitalPatients(HospitalPatients hospitalPatients) {
        restTemplate.postForEntity(url+"/hospitalPatients",hospitalPatients, HospitalPatients.class);
    }

    @Override
    public List<HospitalPatients> getHospitalPatients() {
        return Arrays.asList(restTemplate.getForEntity(url+"/hospitalPatients",HospitalPatients[].class).getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
