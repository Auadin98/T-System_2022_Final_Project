package sk.tsystems.coronastudio.server.webservice.hospitalPatientsServicesREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.hospitalPatients.SlovakiaHospitalPatients;
import sk.tsystems.coronastudio.server.service.hospitalPatientsServices.SlovakiaHospitalPatientsService;

import java.util.List;

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