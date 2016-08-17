package gov.samhsa.c2s.phr.service.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * A clinical statement (e.g. observation,  medication, procedure, encounter, etc.
 * ) embedded in a section.
 * @author Ioana
 * @version 1.0
 * @updated 23-Nov-2015 6:29:30 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClinicalStatement implements Serializable {

	/**
	 * The name of the clinical statement recorded (e.g. sodium, diabetes,
	 * schizophrenia, smoking history) to be displayed.
	 */
	private String name;
	/**
	 * The status may be "active", "resolved", etc.
	 */
	private String status;
	/**
	 * The qualifier may specify additional details (e.g. SIG information for a
	 * medication, 
	 */
	private String qualifier;
	/**
	 * For those statements that have an associated with a value (e.g. sodium result
	 * value,  etc.) this element is used to specify the display value.
	 */
	private String value;
	/**
	 * Business Element identifier in the MDMI Referent Index.
	 */
	private String BEId = "GUID";
	/**
	 * The modifier identifies the clinical statement as :
	 * <ul>
	 * 	<li>clinical observation</li>
	 * 	<li>medication-related record</li>
	 * 	<li>procedure</li>
	 * 	<li>encounter</li>
	 * </ul>
	 */
	private String modifier;
	/**
	 * Date/time of the statement - this is supposed to be a point of in time in the
	 * past unless the statement is related to a care plan intervention.
	 */
	private Date dateTime;
	/**
	 * If the author of the clinical statement is someone other than the section
	 * author, this element may be present.
	 */
	private Provider author;
	private CodedConcept m_CodedConcept;

	public ClinicalStatement(){

	}

	public void finalize() throws Throwable {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQualifier() {
		return qualifier;
	}

	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getBEId() {
		return BEId;
	}

	public void setBEId(String bEId) {
		BEId = bEId;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Provider getAuthor() {
		return author;
	}

	public void setAuthor(Provider author) {
		this.author = author;
	}

	public CodedConcept getM_CodedConcept() {
		return m_CodedConcept;
	}

	public void setM_CodedConcept(CodedConcept m_CodedConcept) {
		this.m_CodedConcept = m_CodedConcept;
	}

}