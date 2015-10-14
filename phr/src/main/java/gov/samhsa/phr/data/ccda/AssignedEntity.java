package gov.samhsa.phr.data.ccda;

public class AssignedEntity
{
	private ContactInformation contact;
	public final ContactInformation getContact()
	{
		return contact;
	}
	public final void setContact(ContactInformation value)
	{
		contact = value;
	}

	private PersonName assignedPerson;
	public final PersonName getAssignedPerson()
	{
		return assignedPerson;
	}
	public final void setAssignedPerson(PersonName value)
	{
		assignedPerson = value;
	}

}