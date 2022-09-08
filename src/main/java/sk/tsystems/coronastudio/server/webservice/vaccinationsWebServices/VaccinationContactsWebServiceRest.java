package sk.tsystems.coronastudio.server.webservice.vaccinationsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.vaccinations.VaccinationContacts;
import sk.tsystems.coronastudio.service.vaccinationsServices.VaccinationContactsService;

import java.util.List;

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
