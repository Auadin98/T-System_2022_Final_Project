package coronastudio.server.webservice.hospitalBedsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.hospitalBeds.DistrictHospitalBeds;
import sk.tsystems.coronastudio.service.hospitalBedsServices.DistrictHospitalBedsService;

import java.util.List;

@RestController
@RequestMapping("/api/districtHospitalBeds")
public class DistrictHospitalBedsWebServiceRest {

    @Autowired
    private DistrictHospitalBedsService districtHospitalBedsService;

    @PostMapping
    public void addDistrictHospitalBeds(@RequestBody DistrictHospitalBeds districtHospitalBeds){
        districtHospitalBedsService.addDistHosBeds(districtHospitalBeds);
    }

    @GetMapping
    public List<DistrictHospitalBeds> getDistrictHospitalBeds(){
        return districtHospitalBedsService.getDistHosBeds();
    }
}
