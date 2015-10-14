package gov.samhsa.phr.data.ccda;

public class Author extends Assigned
{
	private String organizationName;
	public final String getOrganizationName()
	{
		return organizationName;
	}
	public final void setOrganizationName(String value)
	{
		organizationName = value;
	}
}