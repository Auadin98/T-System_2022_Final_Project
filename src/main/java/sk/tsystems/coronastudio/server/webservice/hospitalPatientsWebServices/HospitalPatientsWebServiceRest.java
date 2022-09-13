package sk.tsystems.coronastudio.server.webservice.hospitalPatientsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.hospitalPatients.HospitalPatients;
import sk.tsystems.coronastudio.service.hospitalPatientsServices.HospitalPatientsService;

import java.util.List;

@RestController
@RequestMapping("/api/hospitalPatients")
public class HospitalPatientsWebServiceRest {

    @Autowired
    private HospitalPatientsService hospitalPatientsService;

    @PostMapping
    public void addHospitalPatients(@RequestBody HospitalPatients hospitalPatients){
        hospitalPatientsService.addHospitalPatients(hospitalPatients);
    }

    @GetMapping
    public List<HospitalPatients> getHospitalPatients(){
        return hospitalPatientsService.getHospitalPatients();
    }
}
