package gov.samhsa.mhc.phr.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.samhsa.mhc.phr.service.util.CustomJsonDateDeserializer;
import gov.samhsa.mhc.phr.service.util.CustomJsonDateSerializer;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Jiahao.Li on 6/30/2016.
 */
@Data
public class PatientSearchRequest {
    @NotEmpty
    private String lastName;

    @NotEmpty
    private String firstName;

    @Past
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date birthDate;

    @NotEmpty
    private String genderCode;
}
