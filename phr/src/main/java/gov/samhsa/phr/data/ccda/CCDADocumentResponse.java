package gov.samhsa.phr.data.ccda;

import java.util.*;

public class CCDADocumentResponse
{
	private List<CCDADocumentDto> ccdaDocuments = new ArrayList<CCDADocumentDto>();

	public final List<CCDADocumentDto> getCcdaDocuments()
	{
		return ccdaDocuments;
	}
	public final void setCcdaDocuments(List<CCDADocumentDto> value)
	{
		ccdaDocuments = value;
	}

	private List<CCDADocumentError> errors = new ArrayList<CCDADocumentError>();

	public final List<CCDADocumentError> getErrors()
	{
		return errors;
	}
	public final void setErrors(List<CCDADocumentError> value)
	{
		errors = value;
	}

}