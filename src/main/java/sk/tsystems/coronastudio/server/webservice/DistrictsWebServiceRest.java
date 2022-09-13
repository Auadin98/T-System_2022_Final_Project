package sk.tsystems.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.Districts;
import sk.tsystems.coronastudio.service.DistrictsService;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
public class DistrictsWebServiceRest {

    @Autowired
    private DistrictsService districtsService;

    @PostMapping
    public void addDistricts(@RequestBody Districts districts){
        districtsService.addDistrict(districts);
    }

    @GetMapping
    public List<Districts> getDistricts(){
        return districtsService.getDistricts();
    }
}
