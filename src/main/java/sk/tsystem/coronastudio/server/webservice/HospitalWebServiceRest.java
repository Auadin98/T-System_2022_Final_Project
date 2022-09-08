package sk.tsystem.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystem.coronastudio.entity.Hospitals;
import sk.tsystem.coronastudio.services.HospitalService;

import java.util.List;

public class HospitalWebServiceRest {
    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public void addHospital(@RequestBody Hospitals hospital){
        hospitalService.addHospital(hospital);
    }

    @GetMapping
    public List<Hospitals> getHospitals(){
        return hospitalService.getHospitals();
    }
}
