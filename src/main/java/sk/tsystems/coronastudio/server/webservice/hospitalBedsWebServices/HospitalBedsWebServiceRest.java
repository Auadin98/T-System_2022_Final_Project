package sk.tsystems.coronastudio.server.webservice.hospitalBedsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.hospitalBeds.HospitalBeds;
import sk.tsystems.coronastudio.service.hospitalBedsServices.HospitalBedsService;

import java.util.List;

@RestController
@RequestMapping("/api/hospitalBeds")
public class HospitalBedsWebServiceRest {

    @Autowired
    private HospitalBedsService hospitalBedsService;

    @PostMapping
    public void addHospitalBeds(@RequestBody HospitalBeds hospitalBeds){
        hospitalBedsService.addHosBeds(hospitalBeds);
    }

    @GetMapping
    public List<HospitalBeds> getHospitalBeds(){
        return hospitalBedsService.getHosBeds();
    }
}
