package gov.samhsa.phr.data.ccda;

public class EntryBaseDto
{
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