package sk.tsystems.coronastudio.server.webservice.hospitalBedsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.hospitalBeds.RegionHospitalBeds;
import sk.tsystems.coronastudio.service.hospitalBedsServices.RegionHospitalBedsService;

import java.util.List;

public class RegionHospitalBedsWebServiceRest {

    @Autowired
    private RegionHospitalBedsService regionHospitalBedsService;

    @PostMapping
    public void addRegionHospitalBeds(@RequestBody RegionHospitalBeds regionHospitalBeds){
        regionHospitalBedsService.addRegHosBeds(regionHospitalBeds);
    }

    @GetMapping
    public List<RegionHospitalBeds> getRegionHospitalBeds(){
        return regionHospitalBedsService.getRegHosBeds();
    }
}
