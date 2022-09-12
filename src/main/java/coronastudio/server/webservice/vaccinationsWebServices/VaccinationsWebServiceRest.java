package coronastudio.server.webservice.vaccinationsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.vaccinations.Vaccinations;
import sk.tsystems.coronastudio.service.vaccinationsServices.VaccinationsService;

import java.util.List;

@RestController
@RequestMapping("/api/vaccinations")
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
