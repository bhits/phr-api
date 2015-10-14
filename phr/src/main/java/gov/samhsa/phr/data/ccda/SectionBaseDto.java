package gov.samhsa.phr.data.ccda;

public abstract class SectionBaseDto
{
	private CodedConcept code;
	public final CodedConcept getCode()
	{
		return code;
	}
	public final void setCode(CodedConcept value)
	{
		code = value;
	}

	private String title;
	public final String getTitle()
	{
		return title;
	}
	public final void setTitle(String value)
	{
		title = value;
	}

	private String narrative;
	public final String getNarrative()
	{
		return narrative;
	}
	public final void setNarrative(String value)
	{
		narrative = value;
	}

	private String name;
	public final String getName()
	{
		return name;
	}
	public final void setName(String value)
	{
		name = value;
	}

	private Author author;
	public final Author getAuthor()
	{
		return author;
	}
	public final void setAuthor(Author value)
	{
		author = value;
	}
}