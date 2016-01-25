package gov.samhsa.mhc.phr.jsondomain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * This structure is used to specify address and telephone, email, etc. for a <a
 * href="$element://{CB1E1F61-0E5B-48a5-9CD6-ED81A1D559BD}"><font
 * color="#0000ff"><u>provider</u></font></a> or <a href="$element://{2CDD9FAC-
 * 9A07-4585-BC78-5B98592BA4EB}"><font color="#0000ff"><u>patient</u></font></a>.
 * @author Ioana
 * @version 1.0
 * @updated 23-Nov-2015 6:29:30 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactInfo implements Serializable {

	/**
	 * Address details specified using the <a href="$element://{D4070127-2133-452b-
	 * 91EE-667C8AC39C94}"><font color="#0000ff"><u>Address</u></font></a> class.
	 */
	private Address address;
	/**
	 * This element is used to specify a telecommunication method (e.g, telephone,
	 * email etc.) using the <a href="$element://{40B9FB81-9081-424e-854C-
	 * 427DE03A6213}"><font color="#0000ff"><u>Telecommunication</u></font></a> class.
	 */
	@JsonProperty("telecommunications")
	private List<Telecommunication> telecommunications;

	public ContactInfo(){

	}

	public void finalize() throws Throwable {

	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Telecommunication> getTelecommunications() {
		return telecommunications;
	}

	public void setTelecommunications(List<Telecommunication> telecommunications) {
		this.telecommunications = telecommunications;
	}
}