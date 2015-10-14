package gov.samhsa.phr.data.ccda;

public class Custodian
{
	private String name;
	public final String getName()
	{
		return name;
	}
	public final void setName(String value)
	{
		name = value;
	}

	private ContactInformation contact;
	public final ContactInformation getContact()
	{
		return contact;
	}
	public final void setContact(ContactInformation value)
	{
		contact = value;
	}
}