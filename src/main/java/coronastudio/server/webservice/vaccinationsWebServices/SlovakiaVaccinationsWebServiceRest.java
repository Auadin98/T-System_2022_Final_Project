package coronastudio.server.webservice.vaccinationsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.vaccinations.SlovakiaVaccinations;
import sk.tsystems.coronastudio.service.vaccinationsServices.SlovakiaVaccinationsService;

import java.util.List;

@RestController
@RequestMapping("/api/slovakiaVaccinations")
public class SlovakiaVaccinationsWebServiceRest {

    @Autowired
    private SlovakiaVaccinationsService slovakiaVaccinationsService;

    @PostMapping
    public void addSlovakiaVaccinations(@RequestBody SlovakiaVaccinations slovakiaVaccinations){
        slovakiaVaccinationsService.addSlovakiaVaccinations(slovakiaVaccinations);
    }

    @GetMapping
    public List<SlovakiaVaccinations> getSlovakiaVaccinations(){
        return slovakiaVaccinationsService.getSlovakiaVaccinations();
    }
}
