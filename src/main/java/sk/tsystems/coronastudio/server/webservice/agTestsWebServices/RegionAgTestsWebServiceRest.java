package sk.tsystems.coronastudio.server.webservice.agTestsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.agTests.RegionAgTests;
import sk.tsystems.coronastudio.service.agTestsServices.RegionAgTestsService;

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
