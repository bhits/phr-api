package gov.samhsa.mhc.phr.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Code concept associated with the clinical statement (e.g. test id, medication
 * code, procedure code, etc.).
 * Once clinical statement may references several coded concepts linked to the
 * Section. content elements.
 * @author Ioana
 * @version 1.0
 * @updated 23-Nov-2015 6:29:30 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodedConcept implements Serializable {

	private String displayName;
	private String codeSystem = "oid or uri";
	private String code;

	public CodedConcept(){

	}

	public void finalize() throws Throwable {

	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getCodeSystem() {
		return codeSystem;
	}

	public void setCodeSystem(String codeSystem) {
		this.codeSystem = codeSystem;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}