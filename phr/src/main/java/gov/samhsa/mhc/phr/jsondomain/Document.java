
package gov.samhsa.mhc.phr.jsondomain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Document implements Serializable {
    @JsonProperty("CDAdocuments")
    private List<CDADocument> cdaDocuments;

    public List<CDADocument> getCdaDocuments() {
        return cdaDocuments;
    }

    public void setCdaDocuments(List<CDADocument> cdaDocuments) {
        this.cdaDocuments = cdaDocuments;
    }
}
