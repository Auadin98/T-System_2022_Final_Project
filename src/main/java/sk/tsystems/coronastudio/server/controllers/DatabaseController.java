package sk.tsystems.coronastudio.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import sk.tsystems.coronastudio.service.*;
import sk.tsystems.coronastudio.service.agTestsServices.DistrictAgTestsService;
import sk.tsystems.coronastudio.service.agTestsServices.RegionAgTestsService;
import sk.tsystems.coronastudio.service.agTestsServices.SlovakiaAgTestsService;
import sk.tsystems.coronastudio.service.hospitalBedsServices.DistrictHospitalBedsService;
import sk.tsystems.coronastudio.service.hospitalBedsServices.HospitalBedsService;
import sk.tsystems.coronastudio.service.hospitalBedsServices.RegionHospitalBedsService;
import sk.tsystems.coronastudio.service.hospitalBedsServices.SlovakiaHospitalBedsService;
import sk.tsystems.coronastudio.service.hospitalPatientsServices.DistrictHospitalPatientsService;
import sk.tsystems.coronastudio.service.hospitalPatientsServices.HospitalPatientsService;
import sk.tsystems.coronastudio.service.hospitalPatientsServices.RegionHospitalPatientsService;
import sk.tsystems.coronastudio.service.hospitalPatientsServices.SlovakiaHospitalPatientsService;
import sk.tsystems.coronastudio.service.hospitalStaffServices.HospitalStaffService;
import sk.tsystems.coronastudio.service.vaccinationsServices.RegionVaccinationsService;
import sk.tsystems.coronastudio.service.vaccinationsServices.SlovakiaVaccinationsService;
import sk.tsystems.coronastudio.service.vaccinationsServices.VaccinationContactsService;
import sk.tsystems.coronastudio.service.vaccinationsServices.VaccinationsService;


import java.util.Date;

@Controller
@RequestMapping("/kamene")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class DatabaseController {

    @Autowired
    private CitiesService citiesService;
    @Autowired
    private VaccinesService vaccinesService;
    @Autowired
    private RegionsService regionsService;
    @Autowired
    private DistrictsService districtsService;
    @Autowired
    private HospitalsService hospitalsService;
    @Autowired
    private SlovakiaHospitalBedsService slovakiaHospitalBedsService;
    @Autowired
    private RegionHospitalBedsService regionHospitalBedsService;
    @Autowired
    private DistrictHospitalBedsService districtHospitalBedsService;
    @Autowired
    private HospitalBedsService hospitalBedsService;
    @Autowired
    private SlovakiaVaccinationsService slovakiaVaccinationsService;
    @Autowired
    private RegionVaccinationsService regionVaccinationsService;
    @Autowired
    private VaccinationsService vaccinationsService;
    @Autowired
    private VaccinationContactsService vaccinationContactsService;
    @Autowired
    private HospitalPatientsService hospitalPatientsService;
    @Autowired
    private DistrictHospitalPatientsService districtHospitalPatientsService;
    @Autowired
    private RegionHospitalPatientsService regionHospitalPatientsService;
    @Autowired
    private SlovakiaHospitalPatientsService slovakiaHospitalPatientsService;
    @Autowired
    private HospitalStaffService hospitalStaffService;
    @Autowired
    private SlovakiaAgTestsService slovakiaAgTestsService;
    @Autowired
    private RegionAgTestsService regionAgTestsService;
    @Autowired
    private DistrictAgTestsService districtAgTestsService;

    @RequestMapping
    public String processUserInput(@RequestParam(required = false) Integer row, @RequestParam(required = false) Integer column, Model model) {



        prepareModel(model);
        return "databaseSearch";
    }





    public void prepareModel(Model model) {
        model.addAttribute("getCities", citiesService.getCities());



    }

}
