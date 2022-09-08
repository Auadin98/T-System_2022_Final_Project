package sk.tsystems.coronastudio.server.webservice.vaccinationsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.vaccinations.RegionVaccinations;
import sk.tsystems.coronastudio.entity.vaccinations.Vaccinations;
import sk.tsystems.coronastudio.service.vaccinationsServices.RegionVaccinationsService;
import sk.tsystems.coronastudio.service.vaccinationsServices.VaccinationsService;

import java.util.List;

public class RegionVaccinationsWebServiceRest {

    @Autowired
    private RegionVaccinationsService regionVaccinationsService;

    @PostMapping
    public void addRegionVaccinations(@RequestBody RegionVaccinations regionVaccinations){
        regionVaccinationsService.addRegionVaccinations(regionVaccinations);
    }

    @GetMapping
    public List<RegionVaccinations> getRegionVaccinations(){
        return regionVaccinationsService.getRegionVaccinations();
    }
}
