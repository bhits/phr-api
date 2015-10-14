package gov.samhsa.phr.data.ccda;

public class MedicationOrder
{
	private java.time.LocalDateTime orderedDate = null;
	public final java.time.LocalDateTime getOrderedDate()
	{
		return orderedDate;
	}
	public final void setOrderedDate(java.time.LocalDateTime value)
	{
		orderedDate = value;
	}

	private String status;
	public final String getStatus()
	{
		return status;
	}
	public final void setStatus(String value)
	{
		status = value;
	}

	private String number;
	public final String getNumber()
	{
		return number;
	}
	public final void setNumber(String value)
	{
		number = value;
	}
}