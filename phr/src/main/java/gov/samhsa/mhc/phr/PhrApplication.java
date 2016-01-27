package gov.samhsa.mhc.phr;

import gov.samhsa.mhc.phr.config.PhrConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@SpringBootApplication
@EnableResourceServer
@EnableCaching
public class PhrApplication {

    private static final String RESOURCE_ID ="phr" ;

    public static void main(String[] args) {
        System.out.println("PhrApplication:main() Start");
        Object[] configClasses = {PhrApplication.class , PhrConfig.class};
        SpringApplication.run(configClasses, args);
        System.out.println("PhrApplication:main() End");
    }


    @Bean
    public ResourceServerConfigurer resourceServer(SecurityProperties securityProperties) {
        return new ResourceServerConfigurerAdapter() {
            @Override
            public void configure(ResourceServerSecurityConfigurer resources) {
                resources.resourceId(RESOURCE_ID);
            }

            @Override
            public void configure(HttpSecurity http) throws Exception {
                if (securityProperties.isRequireSsl()) {
                    http.requiresChannel().anyRequest().requiresSecure();
                }
                http.authorizeRequests()
                        .antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('phr.hie_read')")
                        .antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasScope('phr.hie_write')")
                        .antMatchers(HttpMethod.PUT, "/**").access("#oauth2.hasScope('phr.hie_write')");
            }
        };
    }
}
