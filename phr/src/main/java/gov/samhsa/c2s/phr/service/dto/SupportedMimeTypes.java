package gov.samhsa.c2s.phr.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Mime type of the section or document body. Typically the type used for
 * Section. content is HTML. This list is extensible.
 * 
 * @author Ioana
 * @version 1.0
 * @created 23-Nov-2015 2:33:03 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public interface SupportedMimeTypes {
	public final String JSON = "text/javascript";
	public final String TEXT = "text/plain";
	public final String HTML = "text/html";
	public final String PDF = "application/pdf";
	public final String TIFF = "image/tiff";
	public final String PNG = "image/png";
}