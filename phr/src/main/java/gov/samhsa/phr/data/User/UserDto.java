package gov.samhsa.phr.data.User;

public class UserDto
{
	private String refreshToken;
	public final String getRefreshToken()
	{
		return refreshToken;
	}
	public final void setRefreshToken(String value)
	{
		refreshToken = value;
	}
	private String emrn;
	public final String getEmrn()
	{
		return emrn;
	}
	public final void setEmrn(String value)
	{
		emrn = value;
	}
}