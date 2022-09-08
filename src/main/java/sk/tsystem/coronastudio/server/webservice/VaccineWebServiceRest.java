package sk.tsystem.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystem.coronastudio.entity.Regions;
import sk.tsystem.coronastudio.entity.Vaccines;
import sk.tsystem.coronastudio.services.RegionService;
import sk.tsystem.coronastudio.services.VaccineService;

import java.util.List;

public class VaccineWebServiceRest {
    @Autowired
    private VaccineService vaccineService;

    @PostMapping
    public void addVaccine(@RequestBody Vaccines vaccine){
        vaccineService.addVaccine(vaccine);
    }

    @GetMapping
    public List<Vaccines> getVaccines(){
        return vaccineService.getVaccines();
    }
}
