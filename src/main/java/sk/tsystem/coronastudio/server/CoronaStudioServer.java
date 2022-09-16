package sk.tsystem.coronastudio.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import sk.tsystem.coronastudio.entity.AgTests.SlovakiaAgTests;
import sk.tsystem.coronastudio.server.webservice.AgTestsWebServiceRest.AgTestsWebServiceRest;
import sk.tsystem.coronastudio.server.webservice.AgTestsWebServiceRest.DistrictAgTestsWebServiceRest;
import sk.tsystem.coronastudio.services.AgTestsServices.*;
import sk.tsystem.coronastudio.services.CommentService;
import sk.tsystem.coronastudio.services.CommentServiceJPA;
import sk.tsystem.coronastudio.services.UserService;
import sk.tsystem.coronastudio.services.UserServiceJPA;


@SpringBootApplication
@EntityScan(basePackages = "sk.tsystem.coronastudio.entity")
public class CoronaStudioServer {
    public static void main(String[] args) {
        SpringApplication.run(CoronaStudioServer.class);
    }



    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AgTestsService agTestsService(){
        return new AgTestsServiceJPA();
    }
    @Bean
    public DistrictAgTestsService districtAgTestsService(){
        return new DistrictAgTestsServiceJPA();
    }
    @Bean
    public RegionAgTestsService regionAgTestsService(){
        return new RegionAgTestsServiceJPA();
    }
    @Bean
    public SlovakiaAgTestsService slovakiaAgTestsService(){
        return new SlovakiaAgTestsServiceJPA();
    }
    @Bean
    public UserService userService() {
        return new UserServiceJPA();
    }
    @Bean
    public CommentService commentService(){
        return new CommentServiceJPA();
    }
}
