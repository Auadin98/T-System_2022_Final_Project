package coronastudio.server.webservice.vaccinationsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.vaccinations.VaccinationContacts;
import sk.tsystems.coronastudio.service.vaccinationsServices.VaccinationContactsService;

import java.util.List;

@RestController
@RequestMapping("/api/vaccinationContacts")
public class VaccinationContactsWebServiceRest {

    @Autowired
    private VaccinationContactsService vaccinationContactsService;

    @PostMapping
    public void addVaccinationContacts(@RequestBody VaccinationContacts vaccinationContacts){
        vaccinationContactsService.addVaccinationContacts(vaccinationContacts);
    }

    @GetMapping
    public List<VaccinationContacts> getVaccinationContacts(){
        return vaccinationContactsService.getVaccinationContacts();
    }
}
