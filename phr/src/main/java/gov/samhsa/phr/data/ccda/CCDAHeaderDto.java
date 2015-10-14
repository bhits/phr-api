package gov.samhsa.phr.data.ccda;

public class CCDAHeaderDto
{
	private DemographicInformation demographicinformation;
	public final DemographicInformation getDemographicInformation()
	{
		return demographicinformation;
	}
	public final void setDemographicInformation(DemographicInformation value)
	{
		demographicinformation = value;
	}

	private java.time.LocalDateTime documentDateTime = java.time.LocalDateTime.MIN;
	public final java.time.LocalDateTime getDocumentDateTime()
	{
		return documentDateTime;
	}
	public final void setDocumentDateTime(java.time.LocalDateTime value)
	{
		documentDateTime = value;
	}

	private String [] documentTypes;
	public final String[] getDocumentTypes()
	{
		return documentTypes;
	}
	public final void setDocumentTypes(String[] value)
	{
		documentTypes = value;
	}

	private CodedConcept code;
	public final CodedConcept getCode()
	{
		return code;
	}
	public final void setCode(CodedConcept value)
	{
		code = value;
	}

	private CodedConcept language;
	public final CodedConcept getLanguage()
	{
		return language;
	}
	public final void setLanguage(CodedConcept value)
	{
		language = value;
	}

	private String versionNumber;
	public final String getVersionNumber()
	{
		return versionNumber;
	}
	public final void setVersionNumber(String value)
	{
		versionNumber = value;
	}

	// todo: need to confirm this
	private Service service;
	public final Service getService()
	{
		return service;
	}
	public final void setService(Service value)
	{
		service = value;
	}

	private Author author;
	public final Author getAuthor()
	{
		return author;
	}
	public final void setAuthor(Author value)
	{
		author = value;
	}

	private Assigned dataEnterer;
	public final Assigned getDataEnterer()
	{
		return dataEnterer;
	}
	public final void setDataEnterer(Assigned value)
	{
		dataEnterer = value;
	}

	private Assigned informant;
	public final Assigned getInformant()
	{
		return informant;
	}
	public final void setInformant(Assigned value)
	{
		informant = value;
	}

	private InformationRecipient informationRecipient;
	public final InformationRecipient getInformationRecipient()
	{
		return informationRecipient;
	}
	public final void setInformationRecipient(InformationRecipient value)
	{
		informationRecipient = value;
	}

	private Authenticator legalAuthenticator;
	public final Authenticator getLegalAuthenticator()
	{
		return legalAuthenticator;
	}
	public final void setLegalAuthenticator(Authenticator value)
	{
		legalAuthenticator = value;
	}

	private Custodian custodian;
	public final Custodian getCustodian()
	{
		return custodian;
	}
	public final void setCustodian(Custodian value)
	{
		custodian = value;
	}

	private DocumentationOf documentationOf;
	public final DocumentationOf getDocumentationOf()
	{
		return documentationOf;
	}
	public final void setDocumentationOf(DocumentationOf value)
	{
		documentationOf = value;
	}
}