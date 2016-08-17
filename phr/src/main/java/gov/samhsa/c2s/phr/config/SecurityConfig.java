package gov.samhsa.c2s.phr.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


@Configuration
public class SecurityConfig {

    private static final String RESOURCE_ID = "phr";

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
                //Note: The related wildcard pattern must put in the end
                http.authorizeRequests()
                        .antMatchers(HttpMethod.GET, "/patients/healthInformation/**").access("#oauth2.hasScope('phr.hie_read')")
                        .antMatchers(HttpMethod.GET, "/patients/pageNumber/**").access("#oauth2.hasScope('phr.allPatients_read')")
                        .antMatchers(HttpMethod.GET, "/patients/patientDemographic/**").access("#oauth2.hasScope('phr.allPatients_read')")
                        .antMatchers(HttpMethod.GET, "/patients/*/profile").access("#oauth2.hasScope('phr.allPatientProfiles_read')")
                        .antMatchers(HttpMethod.GET, "/patients/*/patientIdentifier").access("#oauth2.hasScope('phr.allPatientProfiles_read')")
                        .antMatchers(HttpMethod.POST, "/patients/**").access("#oauth2.hasScope('phr.hie_write')")
                        .antMatchers(HttpMethod.PUT, "/patients/**").access("#oauth2.hasScope('phr.hie_write')")
                        .antMatchers(HttpMethod.GET, "/patients/**").access("#oauth2.hasScope('phr.patient_read')")
                        .antMatchers(HttpMethod.GET, "/statecodes/**").access("#oauth2.hasScope('phr.patient_read')")
                        .antMatchers(HttpMethod.OPTIONS, "/*/**").permitAll()
                        .anyRequest().denyAll();
            }
        };
    }

    // Uses SHA-256 with multiple iterations and a random salt value.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }
}
