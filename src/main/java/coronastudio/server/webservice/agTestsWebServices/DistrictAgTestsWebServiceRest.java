package coronastudio.server.webservice.agTestsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.agTests.DistrictAgTests;
import sk.tsystems.coronastudio.service.agTestsServices.DistrictAgTestsService;

import java.util.List;

@RestController
@RequestMapping("/api/districtAgTests")
public class DistrictAgTestsWebServiceRest {
    @Autowired
    private DistrictAgTestsService districtAgTestsService;

    @PostMapping
    public void addDisAgTest(@RequestBody DistrictAgTests districtAgTest){
        districtAgTestsService.addDisAgTest(districtAgTest);
    }

    @GetMapping
    public List<DistrictAgTests> getDistAgTests(){
        return districtAgTestsService.getDisAgTests();
    }
}
