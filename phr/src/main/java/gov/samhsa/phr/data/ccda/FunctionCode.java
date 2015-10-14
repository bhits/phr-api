package gov.samhsa.phr.data.ccda;

public class FunctionCode
{
	private String code;
	public final String getCode()
	{
		return code;
	}
	public final void setCode(String value)
	{
		code = value;
	}

	private String codeSystem;
	public final String getCodeSystem()
	{
		return codeSystem;
	}
	public final void setCodeSystem(String value)
	{
		codeSystem = value;
	}

	private String originalText;
	public final String getOriginalText()
	{
		return originalText;
	}
	public final void setOriginalText(String value)
	{
		originalText = value;
	}
}