package sk.tsystems.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.Vaccines;
import sk.tsystems.coronastudio.server.service.VaccinesService;

import java.util.List;

public class VaccinationContactsWebServiceRest {

    @Autowired
    private VaccinesService vaccineService;

    @PostMapping
    public void addVaccine(@RequestBody Vaccines vaccine){
        vaccineService.addVaccine(vaccine);
    }

    @GetMapping
    public List<Vaccines> getVaccines(){
        return vaccineService.getVaccines();
    }
}
