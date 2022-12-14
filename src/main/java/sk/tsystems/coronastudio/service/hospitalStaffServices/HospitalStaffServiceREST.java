package sk.tsystems.coronastudio.service.hospitalStaffServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.entity.hospitalStaff.HospitalStaff;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

public class HospitalStaffServiceREST implements HospitalStaffService{
    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addHospitalStaff(HospitalStaff hospitalStaff) {
        restTemplate.postForEntity(url+"/hospitalStaff", hospitalStaff, HospitalStaff.class);
    }

    @Override
    public List<HospitalStaff> getHospitalStaff() {
        return Arrays.asList(restTemplate.getForEntity(url+"/hospitalStaff/", HospitalStaff[].class).getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web.");
    }
}
