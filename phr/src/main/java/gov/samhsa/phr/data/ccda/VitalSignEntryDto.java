package gov.samhsa.phr.data.ccda;

import java.util.*;

public class VitalSignEntryDto extends EntryBaseDto
{
	private java.time.LocalDateTime effectiveTime = java.time.LocalDateTime.MIN;
	public final java.time.LocalDateTime getEffectiveTime()
	{
		return effectiveTime;
	}
	public final void setEffectiveTime(java.time.LocalDateTime value)
	{
		effectiveTime = value;
	}

	private List<Vital> vitals = new ArrayList<Vital> ();

	public final List<Vital> getVitals()
	{
		return vitals;
	}
	public final void setVitals(List<Vital> value)
	{
		vitals = value;
	}

}