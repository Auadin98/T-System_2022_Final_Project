package sk.tsystems.coronastudio.server.webservice.hospitalPatientsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.hospitalPatients.DistrictHospitalPatients;
import sk.tsystems.coronastudio.service.hospitalPatientsServices.DistrictHospitalPatientsService;

import java.util.List;

@RestController
@RequestMapping("/api/districthospitalPatients")
public class DistrictHospitalPatientsWebServiceRest {

    @Autowired
    private DistrictHospitalPatientsService districthospitalPatientsService;

    @PostMapping
    public void addDistrictHospitalPatients(@RequestBody DistrictHospitalPatients districthospitalPatients){
        districthospitalPatientsService.addDistrictHospitalPatients(districthospitalPatients);
    }

    @GetMapping
    public List<DistrictHospitalPatients> getDistrictHospitalPatients(){
        return districthospitalPatientsService.getDistrictHospitalPatients();
    }
}
