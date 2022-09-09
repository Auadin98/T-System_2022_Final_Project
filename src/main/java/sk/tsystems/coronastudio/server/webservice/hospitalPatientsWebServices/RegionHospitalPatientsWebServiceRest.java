package sk.tsystems.coronastudio.server.webservice.hospitalPatientsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.hospitalPatients.RegionHospitalPatients;
import sk.tsystems.coronastudio.service.hospitalPatientsServices.RegionHospitalPatientsService;

import java.util.List;

@RestController
@RequestMapping("/api/regionHospitalPatients")
public class RegionHospitalPatientsWebServiceRest {
    @Autowired
    private RegionHospitalPatientsService regionHospitalPatientsService;

    @PostMapping
    public void addRegionHospitalPatients(@RequestBody RegionHospitalPatients regionHospitalPatients) {
        regionHospitalPatientsService.addRegionHospitalPatients(regionHospitalPatients);
    }

    @GetMapping
    public List<RegionHospitalPatients> getRegionHospitalPatients() {
        return regionHospitalPatientsService.getRegionHospitalPatients();
    }
}
