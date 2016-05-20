package gov.samhsa.mhc.phr.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Provider information including identifiers, name, and contact information.
 * @author Ioana
 * @version 1.0
 * @updated 23-Nov-2015 6:29:30 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Provider implements Serializable {

	/**
	 * Name of individual provider to delivered the services, formatted for display.
	 * Note that the treating provider's name may be optional if the sending system
	 * incorrectly asserts that the software used may be an author.
	 */
	private String providerName = "Individual Provider Name";
	/**
	 * Provider organization name.
	 */
	private String organizationName = "Provider Organization Name";
	/**
	 * This element may be used incorrectly to specify the author. It should not be
	 * used but was included here for discussion.
	 */
	private String softwareUse = "Software used";
	/**
	 * This optional identifier represents the National Provider Identifer (NPI).
	 * Since CDA documents are not guaranteed to support it, this id reserved for
	 * future uses of this structure.
	 */
	private String nationalProviderId;

	@JsonProperty("contactInfo")
	private ContactInfo m_ContactInfo;

	public Provider(){

	}

	public void finalize() throws Throwable {

	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getSoftwareUse() {
		return softwareUse;
	}

	public void setSoftwareUse(String softwareUse) {
		this.softwareUse = softwareUse;
	}

	public String getNationalProviderId() {
		return nationalProviderId;
	}

	public void setNationalProviderId(String nationalProviderId) {
		this.nationalProviderId = nationalProviderId;
	}

	public ContactInfo getM_ContactInfo() {
		return m_ContactInfo;
	}

	public void setM_ContactInfo(ContactInfo m_ContactInfo) {
		this.m_ContactInfo = m_ContactInfo;
	}
}