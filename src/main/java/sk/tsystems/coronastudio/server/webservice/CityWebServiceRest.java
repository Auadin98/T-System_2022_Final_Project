package sk.tsystems.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.Cities;
import sk.tsystems.coronastudio.server.service.CitiesService;

import java.util.List;

    public class CityWebServiceRest {
        @Autowired
        private CitiesService cityService;

        @PostMapping
        public void addCity(@RequestBody Cities city){
            cityService.addCity(city);
        }

        @GetMapping
        public List<Cities> getCities(){
            return cityService.getCities();
        }

}
