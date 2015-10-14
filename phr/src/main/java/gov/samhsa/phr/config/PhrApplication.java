package gov.samhsa.phr.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "gov.samhsa.phr" })
public class PhrApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhrApplication.class, args);
    }
}
