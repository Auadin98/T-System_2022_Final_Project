package sk.tsystems.coronastudio.server.webservice.hospitalBedsServicesREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.hospitalBeds.HospitalBeds;
import sk.tsystems.coronastudio.server.service.hospitalBedsServices.HospitalBedsService;

import java.util.List;

public class HospitalBedsWebServiceRest {
    @Autowired
    private HospitalBedsService hospitalBedsService;

    @PostMapping
    public void addRegionHospitalBedsService(@RequestBody HospitalBeds hospitalBeds) {
        hospitalBedsService.addHosBeds(hospitalBeds);
    }

    @GetMapping
    public List<HospitalBeds> getHospitalBedsService() {
        return hospitalBedsService.getHosBeds();
    }
}