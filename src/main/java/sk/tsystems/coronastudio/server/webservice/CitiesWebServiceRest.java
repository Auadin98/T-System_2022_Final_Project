package sk.tsystems.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.Cities;
import sk.tsystems.coronastudio.service.CitiesService;

import java.util.List;

public class CitiesWebServiceRest {

    @Autowired
    private CitiesService citiesService;

    @PostMapping
    public void addCities(@RequestBody Cities cities){
        citiesService.addCity(cities);
    }

    @GetMapping
    public List<Cities> getCities(){
        return citiesService.getCities();
    }
}
