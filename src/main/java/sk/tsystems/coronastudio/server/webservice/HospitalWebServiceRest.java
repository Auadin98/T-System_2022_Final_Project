package sk.tsystems.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.Districts;
import sk.tsystems.coronastudio.server.service.DistrictsService;

import java.util.List;

public class HospitalWebServiceRest {
    @Autowired
    private DistrictsService districtService;

    @PostMapping
    public void addDistrict(@RequestBody Districts district) {
        districtService.addDistrict(district);
    }

    @GetMapping
    public List<Districts> getDistricts() {
        return districtService.getDistricts();
    }
}
