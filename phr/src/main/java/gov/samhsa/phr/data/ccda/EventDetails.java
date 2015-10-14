package gov.samhsa.phr.data.ccda;

public class EventDetails
{
	private String condition;
	public final String getCondition()
	{
		return condition;
	}
	public final void setCondition(String value)
	{
		condition = value;
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