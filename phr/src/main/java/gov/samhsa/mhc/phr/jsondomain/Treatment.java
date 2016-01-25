package gov.samhsa.mhc.phr.jsondomain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Treatment whose details that are summarized in this document.
 *
 * @author Ioana
 * @version 1.0
 * @updated 23-Nov-2015 6:29:37 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Treatment implements Serializable {

    /**
     * This element describes the type of treatment/services that were provided to the
     * patient.
     */
    private String service;
    /**
     * Treatment provider - individual and/or organization.
     */
    @JsonProperty("providers")
    private List<Provider> providers;
    /**
     * Treatment start date, this may coincide with the visit or encounter start date.
     */
    private String serviceStartDate;
    /**
     * Treatment end date, this may coincide with the visit or encounter end date.
     */
    private String serviceEndDate;

    public Treatment() {

    }

    public void finalize() throws Throwable {

    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public String getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(String serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public String getServiceEndDate() {
        return serviceEndDate;
    }

    public void setServiceEndDate(String serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }

}