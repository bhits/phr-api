package gov.samhsa.phr.data.ccda;

public class Vital
{
	private CodedConcept type;
	public final CodedConcept getType()
	{
		return type;
	}
	public final void setType(CodedConcept value)
	{
		type = value;
	}

	private String value;
	public final String getValue()
	{
		return value;
	}
	public final void setValue(String value)
	{
		this.value = value;
	}

	private String unit;
	public final String getUnit()
	{
		return unit;
	}
	public final void setUnit(String value)
	{
		unit = value;
	}

	private CodedConcept interpretation;
	public final CodedConcept getInterpretation()
	{
		return interpretation;
	}
	public final void setInterpretation(CodedConcept value)
	{
		interpretation = value;
	}
}