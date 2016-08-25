package gov.samhsa.c2s.phr.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by tomson.ngassa on 7/20/2016.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClinicalDocumentRequest {
    @NotEmpty
    private byte[] document;
}
