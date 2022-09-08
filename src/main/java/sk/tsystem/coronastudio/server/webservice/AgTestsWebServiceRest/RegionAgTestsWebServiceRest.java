package sk.tsystem.coronastudio.server.webservice.AgTestsWebServiceRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystem.coronastudio.entity.AgTests.DistrictAgTests;
import sk.tsystem.coronastudio.entity.AgTests.RegionAgTests;
import sk.tsystem.coronastudio.services.AgTestsServices.DistrictAgTestsService;
import sk.tsystem.coronastudio.services.AgTestsServices.RegionAgTestsService;

import java.util.List;

@RestController
@RequestMapping("/api/regionAgTests")
public class RegionAgTestsWebServiceRest {
    @Autowired
    private RegionAgTestsService regionAgTestsService;

    @PostMapping
    public void addRegAgTest(@RequestBody RegionAgTests regionAgTest){
        regionAgTestsService.addRegAgTest(regionAgTest);
    }

    @GetMapping
    public List<RegionAgTests> getRegAgTests(){
        return regionAgTestsService.getRegAgTests();
    }
}
