package sk.tsystem.coronastudio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystem.coronastudio.entity.HospitalStaff;

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
}
