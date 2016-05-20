package gov.samhsa.mhc.phr.service.dto;


import java.io.Serializable;

/**
 * The address structure used to specify the <a href="$element://{8083D5E4-7893-
 * 434d-80D2-275F6E0B6F9A}"><font color="#0000ff"><u>ContactInfo</u></font></a>.
 * @author Ioana
 * @version 1.0
 * @updated 23-Nov-2015 6:29:30 PM
 */
public class Address implements Serializable {

	/**
	 * Type of address (e.g. home, business etc.)
	 */
	private String type;
	/**
	 * Address line include street, number. etc.
	 */
	private String addressLine;
	/**
	 * City name/code.
	 */
	private String city;
	/**
	 * State name or code.
	 */
	private String state;
	/**
	 * Postal code
	 */
	private String code;
	/**
	 * Country code or name/
	 */
	private String country;

	/**
	 * 
	 */
	public Address(){

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

	}

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return
	 */
	public String getAddressLine() {
		return addressLine;
	}

	/**
	 * @param addressLine
	 */
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return 
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}