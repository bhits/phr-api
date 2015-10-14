package gov.samhsa.phr.data.ccda;

public class CCDADocumentDto
{
	private CCDAHeaderDto ccdaHeaderDto;
	public final CCDAHeaderDto getCCDAHeader()
	{
		return ccdaHeaderDto;
	}
	public final void setCCDAHeader(CCDAHeaderDto value)
	{
		ccdaHeaderDto = value;
	}

	private AllergySectionDto allergySection;
	public final AllergySectionDto getAllergySection()
	{
		return allergySection;
	}
	public final void setAllergySection(AllergySectionDto value)
	{
		allergySection = value;
	}

	private MedicationSectionDto medicationSection;
	public final MedicationSectionDto getMedicationSection()
	{
		return medicationSection;
	}
	public final void setMedicationSection(MedicationSectionDto value)
	{
		medicationSection = value;
	}

	private ProblemSectionDto problemSection;
	public final ProblemSectionDto getProblemSection()
	{
		return problemSection;
	}
	public final void setProblemSection(ProblemSectionDto value)
	{
		problemSection = value;
	}

	private ProcedureSectionDto procedureSection;
	public final ProcedureSectionDto getProcedureSection()
	{
		return procedureSection;
	}
	public final void setProcedureSection(ProcedureSectionDto value)
	{
		procedureSection = value;
	}

	private ResultSectionDto resultSection;
	public final ResultSectionDto getResultSection()
	{
		return resultSection;
	}
	public final void setResultSection(ResultSectionDto value)
	{
		resultSection = value;
	}

	private EncounterSectionDto encounterSection;
	public final EncounterSectionDto getEncounterSection()
	{
		return encounterSection;
	}
	public final void setEncounterSection(EncounterSectionDto value)
	{
		encounterSection = value;
	}

	private VitalSignSectionDto vitalSignSection;
	public final VitalSignSectionDto getVitalSignSection()
	{
		return vitalSignSection;
	}
	public final void setVitalSignSection(VitalSignSectionDto value)
	{
		vitalSignSection = value;
	}
}