package gov.samhsa.phr.data.ccda;

public class Participant
{
	private String role;
	public final String getRole()
	{
		return role;
	}
	public final void setRole(String value)
	{
		role = value;
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