package gov.samhsa.c2s.phr.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import static gov.samhsa.c2s.common.oauth2.OAuth2ScopeUtils.hasScopes;

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
                http.authorizeRequests()
                        .antMatchers(HttpMethod.GET, "/patients/healthInformation/**").access("#oauth2.hasScope('phr.hie_read')")
                        .antMatchers(HttpMethod.POST, "/patients/healthInformation/publish").access("#oauth2.hasScope('phr.hie_write')")
                        .antMatchers(HttpMethod.GET, "/patients/pageNumber/**").access("#oauth2.hasScope('phr.allPatients_read')")
                        .antMatchers(HttpMethod.GET, "/patients/patientDemographic/**").access("#oauth2.hasScope('phr.allPatients_read')")
                        .antMatchers(HttpMethod.GET, "/patients/search/**").access("#oauth2.hasScope('phr.allPatients_read')")
                        .antMatchers(HttpMethod.GET, "/patients/*/profile").access("#oauth2.hasScope('phr.allPatientProfiles_read')")
                        .antMatchers(HttpMethod.GET, "/patients/*/patientIdentifier").access("#oauth2.hasScope('phr.allPatientProfiles_read')")
                        .antMatchers(HttpMethod.PUT, "/patients/*").access(hasScopes("phr.AllPatients_write", "phr.hie_write"))
                        .antMatchers(HttpMethod.GET, "/patients").access("#oauth2.hasScope('phr.patient_read')")
                        .antMatchers(HttpMethod.POST, "/patients").access(hasScopes("phr.hie_write", "registration.write"))
                        .antMatchers(HttpMethod.GET, "/statecodes/**").access("#oauth2.hasScope('phr.patient_read')")
                        .antMatchers(HttpMethod.GET, "/management/**").access("#oauth2.hasScope('phr.management')")
                        .antMatchers(HttpMethod.POST, "/management/**").access("#oauth2.hasScope('phr.management')")
                        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .anyRequest().denyAll();
            }
        };
    }
}
