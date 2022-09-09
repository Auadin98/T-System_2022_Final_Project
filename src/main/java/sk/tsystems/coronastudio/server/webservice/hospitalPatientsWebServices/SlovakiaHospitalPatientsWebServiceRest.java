package sk.tsystems.coronastudio.server.webservice.hospitalPatientsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.hospitalPatients.SlovakiaHospitalPatients;
import sk.tsystems.coronastudio.service.hospitalPatientsServices.SlovakiaHospitalPatientsService;

import java.util.List;

@RestController
@RequestMapping("/api/slovakiaHospitalPatients")
public class SlovakiaHospitalPatientsWebServiceRest {
    @Autowired
    private SlovakiaHospitalPatientsService slovakiaHospitalPatientsService;

    @PostMapping
    public void addSlovakiaHospitalPatients(@RequestBody SlovakiaHospitalPatients slovakiaHospitalPatients) {
        slovakiaHospitalPatientsService.addSlovakiaHospitalPatients(slovakiaHospitalPatients);
    }

    @GetMapping
    public List<SlovakiaHospitalPatients> getSlovakiaHospitalPatients() {
        return slovakiaHospitalPatientsService.getSlovakiaHospitalPatients();
    }
}
