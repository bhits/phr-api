package gov.samhsa.c2s.phr.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Telecommunication info: phone, email, fax, etc. used to specify the <a
 * href="$element://{8083D5E4-7893-434d-80D2-275F6E0B6F9A}"><font
 * color="#0000ff"><u>ContactInfo</u></font></a>.
 * @author Ioana
 * @version 1.0
 * @updated 23-Nov-2015 6:29:37 PM
 */
public class Telecommunication implements Serializable {

	/**
	 * This data element specifies the type of telecom methods (e.g. Tel, Email, etc.)
	 * . This data element may be used as a label for the value element.
	 */
	@JsonProperty("use")
	private String type;
	/**
	 * This is the number o address specified for telecom.
	 */
	private String value;

	public Telecommunication(){

	}

	public void finalize() throws Throwable {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}