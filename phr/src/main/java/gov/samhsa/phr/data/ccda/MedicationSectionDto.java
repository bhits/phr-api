package gov.samhsa.phr.data.ccda;

import java.util.*;

public class MedicationSectionDto extends SectionBaseDto
{
	private List<MedicationEntryDto> medications = new ArrayList<MedicationEntryDto>();

	public final List<MedicationEntryDto> getMedications()
	{
		return medications;
	}
	public final void setMedications(List<MedicationEntryDto> value)
	{
		medications = value;
	}
}