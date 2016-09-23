package gov.samhsa.c2s.phr.config;

import gov.samhsa.c2s.phr.domain.patient.Patient;
import gov.samhsa.c2s.phr.service.dto.PatientDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(createPatientAddressPropertyMapper());
        return modelMapper;
    }

    @Bean
    public RestOperations restTemplate() {
        return new RestTemplate();
    }

    private PropertyMap<Patient, PatientDto> createPatientAddressPropertyMapper() {
        PropertyMap<Patient, PatientDto> patientMap = new PropertyMap<Patient, PatientDto>() {
            protected void configure() {
                map().setAddress(source.getAddress().getStreetAddressLine());
                map().setCity(source.getAddress().getCity());
                map().setStateCode(source.getAddress().getStateCode().getCode());
                map().setZip(source.getAddress().getPostalCode());
            }
        };
        return patientMap;
    }
}
