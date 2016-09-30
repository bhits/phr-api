package gov.samhsa.c2s.phr.service.dto;

import lombok.Data;

@Data
public class LookupDto {
    /**
     * The code.
     */
    private String code;

    /**
     * The code system.
     */
    private String codeSystem;

    /**
     * The display name.
     */
    private String displayName;

    /**
     * The code system name.
     */
    private String codeSystemName;

    /**
     * The original text.
     */
    private String originalText;
}
