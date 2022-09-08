package sk.tsystems.coronastudio.server.webservice.vaccinationsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.vaccinations.Vaccinations;
import sk.tsystems.coronastudio.service.vaccinationsServices.VaccinationsService;

import java.util.List;

public class VaccinationsWebServiceRest {

    @Autowired
    private VaccinationsService vaccinationsService;

    @PostMapping
    public void addVaccinations(@RequestBody Vaccinations vaccinations){
        vaccinationsService.addVaccinations(vaccinations);
    }

    @GetMapping
    public List<Vaccinations> getVaccinations(){
        return vaccinationsService.getVaccinations();
    }
}
