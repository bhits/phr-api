package gov.samhsa.phr.data.ccda;

public class ServiceEvent
{
	private java.time.LocalDateTime effectiveTimeLow = null;
	public final java.time.LocalDateTime getEffectiveTimeLow()
	{
		return effectiveTimeLow;
	}
	public final void setEffectiveTimeLow(java.time.LocalDateTime value)
	{
		effectiveTimeLow = value;
	}

	private java.time.LocalDateTime effectiveTimehigh = null;
	public final java.time.LocalDateTime getEffectiveTimehigh()
	{
		return effectiveTimehigh;
	}
	public final void setEffectiveTimehigh(java.time.LocalDateTime value)
	{
		effectiveTimehigh = value;
	}
}