package gov.samhsa.phr.data.ccda;

public class PersonName
{
	private String givenName;
	public final String getGivenName()
	{
		return givenName;
	}
	public final void setGivenName(String value)
	{
		givenName = value;
	}

	private String familyName;
	public final String getFamilyName()
	{
		return familyName;
	}
	public final void setFamilyName(String value)
	{
		familyName = value;
	}

	private String middleName;
	public final String getMiddleName()
	{
		return middleName;
	}
	public final void setMiddleName(String value)
	{
		middleName = value;
	}

	private String nickName;
	public final String getNickName()
	{
		return nickName;
	}
	public final void setNickName(String value)
	{
		nickName = value;
	}

	private String prefix;
	public final String getPrefix()
	{
		return prefix;
	}
	public final void setPrefix(String value)
	{
		prefix = value;
	}

	private String suffix;
	public final String getSuffix()
	{
		return suffix;
	}
	public final void setSuffix(String value)
	{
		suffix = value;
	}
}