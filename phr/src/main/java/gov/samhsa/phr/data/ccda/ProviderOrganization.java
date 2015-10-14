package gov.samhsa.phr.data.ccda;

public class ProviderOrganization
{
	private String individualProvider;
	public final String getIndividualProvider()
	{
		return individualProvider;
	}
	public final void setIndividualProvider(String value)
	{
		individualProvider = value;
	}

	private String organization;
	public final String getOrganization()
	{
		return organization;
	}
	public final void setOrganization(String value)
	{
		organization = value;
	}
}