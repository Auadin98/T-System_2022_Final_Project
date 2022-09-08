package sk.tsystem.coronastudio.server.webservice.AgTestsWebServiceRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystem.coronastudio.entity.AgTests.AgTests;
import sk.tsystem.coronastudio.entity.AgTests.DistrictAgTests;
import sk.tsystem.coronastudio.services.AgTestsServices.DistrictAgTestsService;

import java.util.List;

@RestController
@RequestMapping("/api/districtAgTests")
public class DistrictAgTestsWebServiceRest {
    @Autowired
    private DistrictAgTestsService districtAgTestsService;

    @PostMapping
    public void addDisAgTest(@RequestBody  DistrictAgTests districtAgTest){
        districtAgTestsService.addDisAgTest(districtAgTest);
    }

    @GetMapping
    public List<DistrictAgTests> getDistAgTests(){
        return districtAgTestsService.getDisAgTests();
    }
}
