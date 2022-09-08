package sk.tsystems.coronastudio.server.webservice.hospitalBedsServicesREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.hospitalBeds.RegionHospitalBeds;

import sk.tsystems.coronastudio.server.service.hospitalBedsServices.RegionHospitalBedsService;


import java.util.List;

public class RegionHospitalBedsWebServiceRest {
    @Autowired
    private RegionHospitalBedsService regionHospitalBedsService;

    @PostMapping
    public void addRegionHospitalBedsService(@RequestBody RegionHospitalBeds regionHospitalBeds) {
        regionHospitalBedsService.addRegHosBeds(regionHospitalBeds);
    }

    @GetMapping
    public List<RegionHospitalBeds> getRegionHospitalBedsService() {
        return regionHospitalBedsService.getRegHosBeds();
    }
}