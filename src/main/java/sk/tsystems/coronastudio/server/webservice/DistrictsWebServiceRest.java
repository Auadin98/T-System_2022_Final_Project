package sk.tsystems.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.Districts;
import sk.tsystems.coronastudio.service.DistrictsService;

import java.util.List;

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
