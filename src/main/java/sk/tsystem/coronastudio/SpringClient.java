package sk.tsystem.coronastudio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;
import sk.tsystem.coronastudio.services.*;


@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = "sk.tsystem.coronastudio.server.*"))
public class SpringClient {
    public static void main (String[] args){

        //SpringApplication.run(SpringClient.class);
        new SpringApplicationBuilder(SpringClient.class).web(WebApplicationType.NONE).run(args);
    }
    @Bean
    public HospitalService hospitalService() {
        return new HospitalServiceJPA();
    }

    @Bean
    public RegionService regionService() {
        return new RegionServiceJPA();
    }

    @Bean
    public DistrictService districtService(){
        return new DistrictServiceJPA();
    }


    @Bean
    public CommandLineRunner runnerJPA(PlaygroundJPA console) {
        return s -> console.play();
    }
    @Bean
    public PlaygroundJPA consoleJPA() {
        return new PlaygroundJPA();
    }




//    @Bean
//
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

}
