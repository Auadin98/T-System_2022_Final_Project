package sk.tsystems.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.Districts;
import sk.tsystems.coronastudio.entity.Hospitals;
import sk.tsystems.coronastudio.server.service.DistrictsService;
import sk.tsystems.coronastudio.server.service.HospitalsService;

import java.util.List;

public class HospitalWebServiceRest {
    @Autowired
    private HospitalsService hospitalsService;

    @PostMapping
    public void addDistrict(@RequestBody Hospitals hospitals) {
        hospitalsService.addHospital(hospitals);
    }

    @GetMapping
    public List<Hospitals> getDistricts() {
        return hospitalsService.getHospitals();
    }
}
