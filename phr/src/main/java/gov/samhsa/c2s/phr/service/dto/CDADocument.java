package gov.samhsa.c2s.phr.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class CDADocument implements Serializable {
    @JsonProperty("date")
    private String date;
    @JsonProperty("type")
    private String type = "Document Type or Template";
    @JsonProperty("id")
    private String id = "id^domain OID";
    @JsonProperty("targetPatient")
    private Patient targetPatient;
    @JsonProperty("treatment")
    private Treatment treatment;
    @JsonProperty("authors")
    private List<Provider> authors;
    @JsonProperty("title")
    private String title = "Document title";
    @JsonProperty("sections")
    private List<Section> sections;

    public CDADocument() {
    }

    public void finalize() throws Throwable {
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Patient getTargetPatient() {
        return this.targetPatient;
    }

    public void setTargetPatient(Patient targetPatient) {
        this.targetPatient = targetPatient;
    }

    public Treatment getTreatment() {
        return this.treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public List<Provider> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<Provider> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Section> getSections() {
        return this.sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
