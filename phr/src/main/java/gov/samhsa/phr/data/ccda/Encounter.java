package gov.samhsa.phr.data.ccda;

public class Encounter
{
	private String id;
	public final String getId()
	{
		return id;
	}
	public final void setId(String value)
	{
		id = value;
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

	private java.time.LocalDateTime timeFrom = java.time.LocalDateTime.MIN;
	public final java.time.LocalDateTime getTimeFrom()
	{
		return timeFrom;
	}
	public final void setTimeFrom(java.time.LocalDateTime value)
	{
		timeFrom = value;
	}

	private java.time.LocalDateTime timeTo = java.time.LocalDateTime.MIN;
	public final java.time.LocalDateTime getTimeTo()
	{
		return timeTo;
	}
	public final void setTimeTo(java.time.LocalDateTime value)
	{
		timeTo = value;
	}

	private String facility;
	public final String getFacility()
	{
		return facility;
	}
	public final void setFacility(String value)
	{
		facility = value;
	}

	private Provider responsibleParty;
	public final Provider getResponsibleParty()
	{
		return responsibleParty;
	}
	public final void setResponsibleParty(Provider value)
	{
		responsibleParty = value;
	}
}