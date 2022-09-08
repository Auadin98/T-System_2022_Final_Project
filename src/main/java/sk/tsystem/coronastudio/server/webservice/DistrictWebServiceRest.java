package sk.tsystem.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystem.coronastudio.entity.AgTests;
import sk.tsystem.coronastudio.entity.Districts;
import sk.tsystem.coronastudio.services.AgTestsService;
import sk.tsystem.coronastudio.services.DistrictService;

import java.util.List;

public class DistrictWebServiceRest {
    @Autowired
    private DistrictService districtService;

    @PostMapping
    public void addDistrict(@RequestBody Districts district){
        districtService.addDistrict(district);
    }

    @GetMapping
    public List<Districts> getDistricts(){
        return districtService.getDistricts();
    }
}
