package sk.tsystems.coronastudio.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "sk.tsystems.coronastudio.entity")
public class CoronaStudioServer {
    public static void main(String[] args) {

        SpringApplication.run(CoronaStudioServer.class);
    }
}
