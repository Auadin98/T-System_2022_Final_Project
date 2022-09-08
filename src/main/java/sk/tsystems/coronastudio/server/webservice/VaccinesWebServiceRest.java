package sk.tsystems.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.Vaccines;
import sk.tsystems.coronastudio.service.VaccinesService;

import java.util.List;

public class VaccinesWebServiceRest {

    @Autowired
    private VaccinesService vaccinesService;

    @PostMapping
    public void addVaccines(@RequestBody Vaccines vaccines){
        vaccinesService.addVaccine(vaccines);
    }

    @GetMapping
    public List<Vaccines> getVaccines(){
        return vaccinesService.getVaccines();
    }
}
