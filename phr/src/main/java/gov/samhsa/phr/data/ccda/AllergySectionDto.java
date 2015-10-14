package gov.samhsa.phr.data.ccda;

import java.util.*;

public class AllergySectionDto extends SectionBaseDto
{
	private List<AllergyEntryDto> allergies = new ArrayList<AllergyEntryDto>();

	public final List<AllergyEntryDto> getAllergies()
	{
		return allergies;
	}
	public final void setAllergies(List<AllergyEntryDto> value)
	{
		allergies = value;
	}
}