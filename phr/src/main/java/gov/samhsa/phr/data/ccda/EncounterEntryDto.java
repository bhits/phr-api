package gov.samhsa.phr.data.ccda;

import java.util.*;

public class EncounterEntryDto extends EntryBaseDto
{
	private CodedConcept type;
	public final CodedConcept getType()
	{
		return type;
	}
	public final void setType(CodedConcept value)
	{
		type = value;
	}

	private java.time.LocalDateTime startDate = java.time.LocalDateTime.MIN;
	public final java.time.LocalDateTime getStartDate()
	{
		return startDate;
	}
	public final void setStartDate(java.time.LocalDateTime value)
	{
		startDate = value;
	}

	private java.time.LocalDateTime endDate = null;
	public final java.time.LocalDateTime getEndDate()
	{
		return endDate;
	}
	public final void setEndDate(java.time.LocalDateTime value)
	{
		endDate = value;
	}

	private List<CodedConcept> indications = new ArrayList<CodedConcept>();

	public final List<CodedConcept> getIndications()
	{
		return indications;
	}
	public final void setIndications(List<CodedConcept> value)
	{
		indications = value;
	}

	private List<CodedConcept> diagnosis = new ArrayList<CodedConcept>();

	public final List<CodedConcept> getDiagnosis()
	{
		return diagnosis;
	}
	public final void setDiagnosis(List<CodedConcept> value)
	{
		diagnosis = value;
	}

	private ContactInformation location;
	public final ContactInformation getLocation()
	{
		return location;
	}
	public final void setLocation(ContactInformation value)
	{
		location = value;
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
}