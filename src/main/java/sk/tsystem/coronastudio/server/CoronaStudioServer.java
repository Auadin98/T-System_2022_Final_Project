package sk.tsystem.coronastudio.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import sk.tsystem.coronastudio.services.AgTestsServices.AgTestsService;
import sk.tsystem.coronastudio.services.AgTestsServices.AgTestsServiceJPA;


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
}
