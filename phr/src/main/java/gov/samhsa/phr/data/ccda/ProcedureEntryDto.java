package gov.samhsa.phr.data.ccda;

import java.util.*;

public class ProcedureEntryDto extends EntryBaseDto
{
	private java.time.LocalDateTime date = java.time.LocalDateTime.MIN;
	public final java.time.LocalDateTime getDate()
	{
		return date;
	}
	public final void setDate(java.time.LocalDateTime value)
	{
		date = value;
	}

	private String type;
	public final String getType()
	{
		return type;
	}
	public final void setType(String value)
	{
		type = value;
	}

	private CodedConcept procedure;
	public final CodedConcept getProcedure()
	{
		return procedure;
	}
	public final void setProcedure(CodedConcept value)
	{
		procedure = value;
	}

	private String [] indications;
	public final String[] getIndications()
	{
		return indications;
	}
	public final void setIndications(String[] value)
	{
		indications = value;
	}

	private String status;
	public final String getStatus()
	{
		return status;
	}
	public final void setStatus(String value)
	{
		status = value;
	}

	private List<Provider> providers = new ArrayList<Provider>();

	public final List<Provider> getProviders()
	{
		return providers;
	}
	public final void setProviders(List<Provider> value)
	{
		providers = value;
	}

	private RepresentedOrganization facility;
	public final RepresentedOrganization getFacility()
	{
		return facility;
	}
	public final void setFacility(RepresentedOrganization value)
	{
		facility = value;
	}

	private String specimen;
	public final String getSpecimen()
	{
		return specimen;
	}
	public final void setSpecimen(String value)
	{
		specimen = value;
	}
}