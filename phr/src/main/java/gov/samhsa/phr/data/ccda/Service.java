package gov.samhsa.phr.data.ccda;

public class Service
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

	private EventDetails eventDetails;
	public final EventDetails getEventDetails()
	{
		return eventDetails;
	}
	public final void setEventDetails(EventDetails value)
	{
		eventDetails = value;
	}

	private ServiceProvider [] serviceProviders;
	public final ServiceProvider[] getServiceProvider()
	{
		return serviceProviders;
	}
	public final void setServiceProvider(ServiceProvider[] value)
	{
		serviceProviders = value;
	}
}