package gov.samhsa.phr.data.ccda;

import java.util.*;

public class EncounterSectionDto extends SectionBaseDto
{
	private List<EncounterEntryDto> encounters = new ArrayList<EncounterEntryDto>();

	public final List<EncounterEntryDto> getEncounters()
	{
		return encounters;
	}
	public final void setEncounters(List<EncounterEntryDto> value)
	{
		encounters = value;
	}
}