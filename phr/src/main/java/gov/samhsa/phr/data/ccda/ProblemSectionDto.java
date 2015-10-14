package gov.samhsa.phr.data.ccda;

import java.util.*;

public class ProblemSectionDto extends SectionBaseDto
{
	private List<ProblemEntryDto> problems = new ArrayList<ProblemEntryDto>();

	public final List<ProblemEntryDto> getProblems()
	{
		return problems;
	}
	public final void setProblems(List<ProblemEntryDto> value)
	{
		problems = value;
	}
}