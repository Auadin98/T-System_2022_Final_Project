package sk.tsystems.coronastudio.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EntityScan(basePackages = "sk.tsystems.coronastudio.entity")
public class GameStudioServer {
    public static void main(String[] args) {
        SpringApplication.run(GameStudioServer.class);
    }



    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
