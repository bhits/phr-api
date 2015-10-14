package gov.samhsa.phr.data.ccda;

import java.util.*;

public class AllergyEntryDto extends EntryBaseDto
{
	private List<CodedConcept> reactions;
	public final List<CodedConcept> getReactions()
	{
		return reactions;
	}
	public final void setReactions(List<CodedConcept> value)
	{
		reactions = value;
	}

	private CodedConcept severity;
	public final CodedConcept getSeverity()
	{
		return severity;
	}
	public final void setSeverity(CodedConcept value)
	{
		severity = value;
	}

	private CodedConcept substance;
	public final CodedConcept getSubstance()
	{
		return substance;
	}
	public final void setSubstance(CodedConcept value)
	{
		substance = value;
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

	private java.time.LocalDateTime startDate = null;
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
}