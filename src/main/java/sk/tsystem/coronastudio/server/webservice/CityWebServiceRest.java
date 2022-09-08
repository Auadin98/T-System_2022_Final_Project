package sk.tsystem.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystem.coronastudio.entity.AgTests;
import sk.tsystem.coronastudio.entity.Cities;
import sk.tsystem.coronastudio.services.AgTestsService;
import sk.tsystem.coronastudio.services.CityService;

import java.util.List;

public class CityWebServiceRest {
    @Autowired
    private CityService cityService;

    @PostMapping
    public void addCity(@RequestBody Cities city){
        cityService.addCity(city);
    }

    @GetMapping
    public List<Cities> getCities(){
        return cityService.getCities();
    }

}
