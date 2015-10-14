package gov.samhsa.phr.data.ccda;

public class InformationRecipient
{
	private PersonName name;
	public final PersonName getName()
	{
		return name;
	}
	public final void setName(PersonName value)
	{
		name = value;
	}

	private String receivedOrganization;
	public final String getReceivedOrganization()
	{
		return receivedOrganization;
	}
	public final void setReceivedOrganization(String value)
	{
		receivedOrganization = value;
	}
}