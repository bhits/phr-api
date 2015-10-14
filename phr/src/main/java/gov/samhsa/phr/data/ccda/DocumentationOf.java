package gov.samhsa.phr.data.ccda;

public class DocumentationOf
{
	private ServiceEvent serviceEvent;
	public final ServiceEvent getServiceEvent()
	{
		return serviceEvent;
	}
	public final void setServiceEvent(ServiceEvent value)
	{
		serviceEvent = value;
	}

	private Performer performer;
	public final Performer getPerformer()
	{
		return performer;
	}
	public final void setPerformer(Performer value)
	{
		performer = value;
	}
}