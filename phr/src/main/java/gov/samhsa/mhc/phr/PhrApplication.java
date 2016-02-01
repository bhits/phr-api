package gov.samhsa.mhc.phr;

import gov.samhsa.mhc.phr.config.WebConfig;
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
        System.out.println("PhrApplication:main() Start");
        Object[] configClasses = {PhrApplication.class, WebConfig.class};
        SpringApplication.run(configClasses, args);
        System.out.println("PhrApplication:main() End");
        SpringApplication.run(PhrApplication.class, args);
    }

}
