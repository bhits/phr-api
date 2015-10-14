package gov.samhsa.phr.data.ccda;

import java.util.*;

public class VitalSignSectionDto extends SectionBaseDto
{
	private List<VitalSignEntryDto> vitalSigns = new ArrayList<VitalSignEntryDto>();

	public final List<VitalSignEntryDto> getVitalSigns()
	{
		return vitalSigns;
	}
	public final void setVitalSigns(List<VitalSignEntryDto> value)
	{
		vitalSigns = value;
	}
}