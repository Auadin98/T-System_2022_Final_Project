package coronastudio.server.webservice.hospitalBedsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.hospitalBeds.RegionHospitalBeds;
import sk.tsystems.coronastudio.service.hospitalBedsServices.RegionHospitalBedsService;

import java.util.List;

@RestController
@RequestMapping("/api/regionHospitalBeds")
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
