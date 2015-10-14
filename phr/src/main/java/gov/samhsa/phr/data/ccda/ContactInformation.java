package gov.samhsa.phr.data.ccda;

import java.util.*;

public class ContactInformation
{
	private AddressDto address;
	public final AddressDto getAddress()
	{
		return address;
	}
	public final void setAddress(AddressDto value)
	{
		address = value;
	}

	private String email;
	public final String getEmail()
	{
		return email;
	}
	public final void setEmail(String value)
	{
		email = value;
	}

	private List<TeleCommunication> phones;
	public final List<TeleCommunication> getPhones()
	{
		return phones;
	}
	public final void setPhones(List<TeleCommunication> value)
	{
		phones = value;
	}
}