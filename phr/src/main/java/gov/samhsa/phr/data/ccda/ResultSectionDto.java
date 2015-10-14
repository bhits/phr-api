package gov.samhsa.phr.data.ccda;

import java.util.*;

public class ResultSectionDto extends SectionBaseDto
{
	private List<ResultEntryDto> results = new ArrayList<ResultEntryDto>();

	public final List<ResultEntryDto> getResults()
	{
		return results;
	}
	public final void setResults(List<ResultEntryDto> value)
	{
		results = value;
	}
}