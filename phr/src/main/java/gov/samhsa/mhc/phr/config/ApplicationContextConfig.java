package gov.samhsa.mhc.phr.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
