package gov.samhsa.phr.data.ccda;

import java.util.*;

public class Assigned
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

	private List<ContactInformation> contacts;
	public final List<ContactInformation> getContacts()
	{
		return contacts;
	}
	public final void setContacts(List<ContactInformation> value)
	{
		contacts = value;
	}
}