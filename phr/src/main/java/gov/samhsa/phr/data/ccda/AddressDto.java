package gov.samhsa.phr.data.ccda;

public class AddressDto
{
	private String streetName1;
	public final String getStreetName1()
	{
		return streetName1;
	}
	public final void setStreetName1(String value)
	{
		streetName1 = value;
	}

	private String streetName2;
	public final String getStreetName2()
	{
		return streetName2;
	}
	public final void setStreetName2(String value)
	{
		streetName2 = value;
	}

	private String country;
	public final String getCountry()
	{
		return country;
	}
	public final void setCountry(String value)
	{
		country = value;
	}

	private String city;
	public final String getCity()
	{
		return city;
	}
	public final void setCity(String value)
	{
		city = value;
	}

	private int zipcode;
	public final int getZipcode()
	{
		return zipcode;
	}
	public final void setZipcode(int value)
	{
		zipcode = value;
	}
}