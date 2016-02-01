package gov.samhsa.mhc.phr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableCaching
@EnableAspectJAutoProxy
public class PhrApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhrApplication.class, args);
    }

}
