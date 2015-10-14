package gov.samhsa.phr.data.ccda;

public class ResultEntryDto extends EntryBaseDto
{
	private String specificTest;
	public final String getSpecificTest()
	{
		return specificTest;
	}
	public final void setSpecificTest(String value)
	{
		specificTest = value;
	}

	private String testResults;
	public final String getTestResults()
	{
		return testResults;
	}
	public final void setTestResults(String value)
	{
		testResults = value;
	}

	private String lab;
	public final String getLab()
	{
		return lab;
	}
	public final void setLab(String value)
	{
		lab = value;
	}

	private java.time.LocalDateTime dateReported = java.time.LocalDateTime.MIN;
	public final java.time.LocalDateTime getDateReported()
	{
		return dateReported;
	}
	public final void setDateReported(java.time.LocalDateTime value)
	{
		dateReported = value;
	}
}