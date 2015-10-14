package gov.samhsa.phr.data.ccda;

public class ServiceProvider
{
	private String type;
	public final String getType()
	{
		return type;
	}
	public final void setType(String value)
	{
		type = value;
	}

	private ProviderOrganization provider;
	public final ProviderOrganization getProvider()
	{
		return provider;
	}
	public final void setProvider(ProviderOrganization value)
	{
		provider = value;
	}
}