package gov.samhsa.mhc.phr.jsondomain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * This structure is intended to describe the sections of a structured document
 * (organized into sections) or the content of an unstructured/monolithic document.
 * 
 * By default, this structure does not support sub-sections because they have not
 * been adopted by industry and they add a recursive complexity to any user
 * interface.
 * Consolidated CDA document implementation guides have not used sub-sections so
 * far but this structure can be enhanced by adding a reference from one parent
 * section to child/sub-section.
 * @author Ioana
 * @version 1.0
 * @updated 23-Nov-2015 6:29:31 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Section implements Serializable {

	/**
	 * Section title (e.g. "Discharge Instructions") intended for display.
	 */
	private String title = "Section title";
	/**
	 * Section content - typically HTML or plain text.
	 */
	private String content;
	/**
	 * Business element unique id, it's intended to associate the section with a
	 * Referent Index element for mapping to/from the document structure.
	 */
	private String BEid;
	/**
	 * The mime type of the section or "nonXMLDocument" content. By default, it is set
	 * to "application/html". If the section contains the entire document body, this
	 * type will be "text/plain" by default.
	 */
	private String contentMimeType = SupportedMimeTypes.HTML;
	/**
	 * The section author is optional; it will be set only of the section was authored
	 * by someone other than the author document (i.e. Document. author).
	 */
	private Provider author;

	private List<ClinicalStatement> m_ClinicalStatements;

	/**
	 * 
	 */
	public Section(){

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

	}

	/**
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return
	 */
	public String getBEid() {
		return BEid;
	}

	/**
	 * @param bEid
	 */
	public void setBEid(String bEid) {
		BEid = bEid;
	}

	/**
	 * @return
	 */
	public String getContentMimeType() {
		return contentMimeType;
	}

	/**
	 * @param contentMimeType
	 */
	public void setContentMimeType(String contentMimeType) {
		this.contentMimeType = contentMimeType;
	}

	/**
	 * @return
	 */
	public Provider getAuthor() {
		return author;
	}

	/**
	 * @param author
	 */
	public void setAuthor(Provider author) {
		this.author = author;
	}

	public List<ClinicalStatement> getM_ClinicalStatements() {
		return m_ClinicalStatements;
	}

	public void setM_ClinicalStatements(List<ClinicalStatement> m_ClinicalStatements) {
		this.m_ClinicalStatements = m_ClinicalStatements;
	}
}