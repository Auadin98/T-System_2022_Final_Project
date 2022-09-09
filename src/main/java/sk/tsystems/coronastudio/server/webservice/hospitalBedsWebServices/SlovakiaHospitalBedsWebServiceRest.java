package sk.tsystems.coronastudio.server.webservice.hospitalBedsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.hospitalBeds.HospitalBeds;
import sk.tsystems.coronastudio.entity.hospitalBeds.SlovakiaHospitalBeds;
import sk.tsystems.coronastudio.service.hospitalBedsServices.HospitalBedsService;
import sk.tsystems.coronastudio.service.hospitalBedsServices.SlovakiaHospitalBedsService;

import java.util.List;

@RestController
@RequestMapping("/api/slovakiaHospitalBeds")
public class SlovakiaHospitalBedsWebServiceRest {

    @Autowired
    private SlovakiaHospitalBedsService slovakiaHospitalBedsService;

    @PostMapping
    public void addSlovakiaHospitalBeds(@RequestBody SlovakiaHospitalBeds slovakiaHospitalBeds){
        slovakiaHospitalBedsService.addSlovHosBeds(slovakiaHospitalBeds);
    }

    @GetMapping
    public List<SlovakiaHospitalBeds> getSlovakiaHospitalBeds(){
        return slovakiaHospitalBedsService.getSlovHosBeds();
    }
}
