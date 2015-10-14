package gov.samhsa.phr.data.ccda;

public class Authenticator extends Assigned
{
	private String signatureCode;
	public final String getSignatureCode()
	{
		return signatureCode;
	}
	public final void setSignatureCode(String value)
	{
		signatureCode = value;
	}
}