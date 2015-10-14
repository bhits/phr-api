package gov.samhsa.phr.data.ccda;

public class ProblemEntryDto extends EntryBaseDto
{
	private CodedConcept condition;
	public final CodedConcept getCondition()
	{
		return condition;
	}
	public final void setCondition(CodedConcept value)
	{
		condition = value;
	}

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

	private Integer ageAtOnSet = null;
	public final Integer getAgeAtOnSet()
	{
		return ageAtOnSet;
	}
	public final void setAgeAtOnSet(Integer value)
	{
		ageAtOnSet = value;
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

	private CodedConcept healthStatus;
	public final CodedConcept getHealthStatus()
	{
		return healthStatus;
	}
	public final void setHealthStatus(CodedConcept value)
	{
		healthStatus = value;
	}
}