package sk.tsystems.coronastudio.server.webservice.vaccinationsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.ObjectsDTO.VaccinationsRegDTO;
import sk.tsystems.coronastudio.entity.vaccinations.RegionVaccinations;
import sk.tsystems.coronastudio.entity.vaccinations.Vaccinations;
import sk.tsystems.coronastudio.service.vaccinationsServices.RegionVaccinationsService;
import sk.tsystems.coronastudio.service.vaccinationsServices.VaccinationsService;

import java.util.List;

@RestController
@RequestMapping("/api/regionVaccinations")
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

    @GetMapping("/regDoseVacc")
    public List<VaccinationsRegDTO> getRegDoseVacc(){
        return regionVaccinationsService.getRegDoseVacc();
    }
}
