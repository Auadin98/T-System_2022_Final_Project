package sk.tsystems.coronastudio.server.webservice.hospitalBedsServicesREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.hospitalBeds.SlovakiaHospitalBeds;
import sk.tsystems.coronastudio.server.service.hospitalBedsServices.SlovakiaHospitalBedsService;

import java.util.List;

public class SlovakiaHospitalBedsWebServiceRest {
    @Autowired
    private SlovakiaHospitalBedsService slovakiaHospitalBedsService;

    @PostMapping
    public void addRegionHospitalBedsService(@RequestBody SlovakiaHospitalBeds slovakiaHospitalBeds) {
        slovakiaHospitalBedsService.addSlovHosBeds(slovakiaHospitalBeds);
    }

    @GetMapping
    public List<SlovakiaHospitalBeds> getRegionHospitalBedsService() {
        return slovakiaHospitalBedsService.getSlovHosBeds();
    }
}