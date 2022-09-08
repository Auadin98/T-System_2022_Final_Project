package sk.tsystems.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.Hospitals;
import sk.tsystems.coronastudio.service.HospitalsService;

import java.util.List;

public class HospitalsWebServiceRest {

    @Autowired
    private HospitalsService hospitalsService;

    @PostMapping
    public void addHospitals(@RequestBody Hospitals hospitals){
        hospitalsService.addHospital(hospitals);
    }

    @GetMapping
    public List<Hospitals> getHospitals(){
        return hospitalsService.getHospitals();
    }
}
