package sk.tsystems.coronastudio.server.webservice.hospitalPatientsServicesREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.hospitalPatients.RegionHospitalPatients;
import sk.tsystems.coronastudio.server.service.hospitalPatientsServices.RegionHospitalPatientsService;

import java.util.List;

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