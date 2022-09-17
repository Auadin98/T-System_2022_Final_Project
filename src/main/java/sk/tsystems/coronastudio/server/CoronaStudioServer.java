package sk.tsystems.coronastudio.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import sk.tsystems.coronastudio.database.UpdateDB;
import sk.tsystems.coronastudio.service.*;
import sk.tsystems.coronastudio.service.agTestsServices.*;
import sk.tsystems.coronastudio.service.hospitalBedsServices.*;
import sk.tsystems.coronastudio.service.hospitalPatientsServices.*;
import sk.tsystems.coronastudio.service.hospitalStaffServices.HospitalStaffService;
import sk.tsystems.coronastudio.service.hospitalStaffServices.HospitalStaffServiceJPA;
import sk.tsystems.coronastudio.service.userServices.CommentService;
import sk.tsystems.coronastudio.service.userServices.CommentServiceJPA;
import sk.tsystems.coronastudio.service.userServices.UserService;
import sk.tsystems.coronastudio.service.userServices.UserServiceJPA;
import sk.tsystems.coronastudio.service.vaccinationsServices.*;

@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = "sk.tsystems.coronastudio.entity")
public class CoronaStudioServer {
    public static void main(String[] args) {
        SpringApplication.run(CoronaStudioServer.class);
    }

    @Bean
    public UpdateDB consoleJPA(){
        return new UpdateDB();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CitiesService citiesService() { return new CitiesServiceJPA();}

    @Bean
    public VaccinesService vaccinesService() {return new VaccinesServiceJPA();}

    @Bean
    public RegionsService regionsService() {return new RegionsServiceJPA();}

    @Bean
    public DistrictsService districtsService() {return new DistrictsServiceJPA();}

    @Bean
    public HospitalsService hospitalsService() {return new HospitalsServiceJPA();}

    @Bean
    public SlovakiaHospitalBedsService slovakiaHospitalBedsService() {return new SlovakiaHospitalBedsServiceJPA();}

    @Bean
    public RegionHospitalBedsService regionHospitalBedsService(){return new RegionHospitalBedsServiceJPA();}

    @Bean
    public DistrictHospitalBedsService districtHospitalBedsService(){return new DistrictHospitalBedsServiceJPA();}

    @Bean
    public HospitalBedsService hospitalBedsService(){return new HospitalBedsServiceJPA();}

    @Bean
    public SlovakiaVaccinationsService slovakiaVaccinationsService(){return new SlovakiaVaccinationsServiceJPA();}

    @Bean
    public RegionVaccinationsService regionVaccinationsService(){return new RegionVaccinationsServiceJPA();}

    @Bean
    public VaccinationsService vaccinationsService(){return new VaccinationsServiceJPA();}

    @Bean
    public VaccinationContactsService vaccinationContactsService(){return new VaccinationContactsServiceJPA();}

    @Bean
    public DistrictHospitalPatientsService districtHospitalPatientsService(){
        return new DistrictHospitalPatientsServiceJPA();
    }

    @Bean
    public HospitalPatientsService hospitalPatientsService(){return new HospitalPatientsServiceJPA();
    }

    @Bean
    public RegionHospitalPatientsService regionHospitalPatientsService(){return new RegionHospitalPatientsServiceJPA();}

    @Bean
    public SlovakiaHospitalPatientsService slovakiaHospitalPatientsService(){return new SlovakiaHospitalPatientsServiceJPA();}

    @Bean
    public HospitalStaffService hospitalStaffService(){return new HospitalStaffServiceJPA();}

    @Bean
    public SlovakiaAgTestsService slovakiaAgTestsService(){return new SlovakiaAgTestsServiceJPA();}

    @Bean
    public RegionAgTestsService regionAgTestsService(){return new RegionAgTestsServiceJPA();}

    @Bean
    public DistrictAgTestsService districtAgTestsService(){return new DistrictAgTestsServiceJPA();}

    @Bean
    public UserService userService() {
        return new UserServiceJPA();
    }
    @Bean
    public CommentService commentService(){
        return new CommentServiceJPA();
    }
}
