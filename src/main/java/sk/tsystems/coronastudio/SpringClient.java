package sk.tsystems.coronastudio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import sk.tsystems.coronastudio.database.PlaygroundJPA;
import sk.tsystems.coronastudio.service.*;
import sk.tsystems.coronastudio.service.hospitalBedsServices.*;
import sk.tsystems.coronastudio.service.vaccinationsServices.RegionVaccinationsService;
import sk.tsystems.coronastudio.service.vaccinationsServices.RegionVaccinationsServiceJPA;
import sk.tsystems.coronastudio.service.vaccinationsServices.SlovakiaVaccinationsService;
import sk.tsystems.coronastudio.service.vaccinationsServices.SlovakiaVaccinationsServiceJPA;

@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "sk.tsystems.coronastudio.server.*"))
public class SpringClient {

    public static void main(String[] args) {
        //eSpringApplication.run(SpringClient.class);
        new SpringApplicationBuilder(SpringClient.class).web(WebApplicationType.NONE).run(args);
    }

    @Bean
    public CommandLineRunner runnerJPA(PlaygroundJPA console) {
        return s -> console.play();
    }

    @Bean
    public PlaygroundJPA consoleJPA(){
        return new PlaygroundJPA();
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
    public RegionVaccinationsService regionVaccinationsService(){return new RegionVaccinationsServiceJPA();
    }

}
