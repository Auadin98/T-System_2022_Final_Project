package sk.tsystem.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystem.coronastudio.entity.HospitalStaff;
import sk.tsystem.coronastudio.entity.Hospitals;
import sk.tsystem.coronastudio.services.HospitalService;
import sk.tsystem.coronastudio.services.HospitalStaffService;

import java.util.List;

public class HospitalStaffWebServiceRest {
    @Autowired
    private HospitalStaffService hospitalStaffService;

    @PostMapping
    public void addHospitalStaff(@RequestBody HospitalStaff hospitalStaff){
        hospitalStaffService.addHospitalStaff(hospitalStaff);
    }

    @GetMapping
    public List<HospitalStaff> getHospitalStaff(){
        return hospitalStaffService.getHospitalStaff();
    }
}
