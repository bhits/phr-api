package gov.samhsa.phr.data.Lookup;

public class GenderDto
{
	// todo: need to implement codedconcept
	private String code;
	public final String getCode()
	{
		return code;
	}
	public final void setCode(String value)
	{
		code = value;
	}

	private String value;
	public final String getValue()
	{
		return value;
	}
	public final void setValue(String value)
	{
		this.value = value;
	}
}