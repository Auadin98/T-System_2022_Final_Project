package sk.tsystems.coronastudio;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import sk.tsystems.coronastudio.database.UpdateDB;
import sk.tsystems.coronastudio.service.*;
import sk.tsystems.coronastudio.service.agTestsServices.*;
import sk.tsystems.coronastudio.service.hospitalBedsServices.*;
import sk.tsystems.coronastudio.service.hospitalPatientsServices.*;
import sk.tsystems.coronastudio.service.hospitalStaffServices.HospitalStaffService;
import sk.tsystems.coronastudio.service.hospitalStaffServices.HospitalStaffServiceJPA;
import sk.tsystems.coronastudio.service.vaccinationsServices.*;

@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "sk.tsystems.coronastudio.server.*"))
public class SpringClient {

    public static void main(String[] args) {
        //eSpringApplication.run(SpringClient.class);
        new SpringApplicationBuilder(SpringClient.class).web(WebApplicationType.NONE).run(args);
    }

    @Bean
    public CommandLineRunner runnerJPA(UpdateDB console) {
        return s -> console.play();
    }

//    @Bean
//    public UpdateDB consoleJPA(){
//        return new UpdateDB();
//    }

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

}
