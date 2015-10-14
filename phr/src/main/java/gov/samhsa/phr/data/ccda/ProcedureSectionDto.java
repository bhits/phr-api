package gov.samhsa.phr.data.ccda;

import java.util.*;

public class ProcedureSectionDto extends SectionBaseDto
{
	private List<ProcedureEntryDto> procedures = new ArrayList<ProcedureEntryDto>();
	public final List<ProcedureEntryDto> getProcedures()
	{
		return procedures;
	}
	public final void setProcedures(List<ProcedureEntryDto> value)
	{
		procedures = value;
	}
}