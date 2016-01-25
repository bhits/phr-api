package gov.samhsa.mhc.phr.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@SpringBootApplication
@EnableResourceServer
@EnableCaching
@ComponentScan(basePackages = {"gov.samhsa.mhc.phr" })
public class PhrApplication extends SpringBootServletInitializer {

    private static final String RESOURCE_ID ="phr" ;

    public static void main(String[] args) {
        System.out.println("PhrApplication:main() Start");
        Object[] configClasses = {PhrApplication.class , PhrConfig.class};
        SpringApplication.run(configClasses, args);
        System.out.println("PhrApplication:main() End");
        // SpringApplication.run(PhrApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PhrApplication.class);
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
                        //.antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('phr.hie_read')")
                        .antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasScope('phr.hie_write')")
                        .antMatchers(HttpMethod.PUT, "/**").access("#oauth2.hasScope('phr.hie_write')");
            }
        };
    }
}
