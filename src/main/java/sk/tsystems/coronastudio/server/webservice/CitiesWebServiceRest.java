package sk.tsystems.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.Cities;
import sk.tsystems.coronastudio.service.CitiesService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cities")
public class CitiesWebServiceRest {

    @Autowired
    private CitiesService citiesService;

    @PostMapping
    public void addCities(@RequestBody Cities cities){
        citiesService.addCity(cities);
    }

    @GetMapping("/ActualDataTestTDO")
    public List<Map<String, Object>> actualDataTestTDOS(){
        return citiesService.getActualDataCities();
    }

    @GetMapping
    public List<Cities> getCities(){
        return citiesService.getCities();
    }
}
