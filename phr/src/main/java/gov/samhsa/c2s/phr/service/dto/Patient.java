package gov.samhsa.c2s.phr.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Patient details including patient identifying traits and contact information.
 *
 * @author Ioana
 * @version 1.0
 * @updated 23-Nov-2015 6:29:30 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient implements Serializable {

    @JsonProperty("contactInfo")
    private ContactInfo m_ContactInfo;
    /**
     * Patien't date of birth.
     */

    private String dob;
    /**
     * Patient's gender.
     */
    private String gender;
    /**
     * Patient's race.
     */
    private String race;
    /**
     * Patient's ethnicity.
     */
    private String ethnicity;
    /**
     * Patient's name.
     */
    private String name = "Patient Full Name";
    /**
     * Patient id.patient id^root oid
     */
    @JsonProperty("ids")
    private List<String> ids;
    public Patient() {

    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public void finalize() throws Throwable {

    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public ContactInfo getM_ContactInfo() {
        return m_ContactInfo;
    }

    public void setM_ContactInfo(ContactInfo m_ContactInfo) {
        this.m_ContactInfo = m_ContactInfo;
    }

}