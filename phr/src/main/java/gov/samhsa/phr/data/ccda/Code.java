package gov.samhsa.phr.data.ccda;

public class Code
{
	private String value;
	public final String getValue()
	{
		return value;
	}
	public final void setValue(String value)
	{
		this.value = value;
	}

	private String codeSystem;
	public final String getCodeSystem()
	{
		return codeSystem;
	}
	public final void setCodeSystem(String value)
	{
		codeSystem = value;
	}

	private String codeSystemName;
	public final String getCodeSystemName()
	{
		return codeSystemName;
	}
	public final void setCodeSystemName(String value)
	{
		codeSystemName = value;
	}

	private String displayName;
	public final String getDisplayName()
	{
		return displayName;
	}
	public final void setDisplayName(String value)
	{
		displayName = value;
	}
}