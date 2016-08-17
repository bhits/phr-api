package gov.samhsa.c2s.phr.service.dto;

/**
 * Created by tomson.ngassa on 3/25/2016.
 */
public class LookupDto {
    /** The code. */
    private String code;

    /** The code system. */
    private String codeSystem;

    /** The display name. */
    private String displayName;

    /** The code system name. */
    private String codeSystemName;

    /** The original text. */
    private String originalText;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeSystem() {
        return codeSystem;
    }

    public void setCodeSystem(String codeSystem) {
        this.codeSystem = codeSystem;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCodeSystemName() {
        return codeSystemName;
    }

    public void setCodeSystemName(String codeSystemName) {
        this.codeSystemName = codeSystemName;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }
}
