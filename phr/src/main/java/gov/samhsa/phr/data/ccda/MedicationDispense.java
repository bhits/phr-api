package gov.samhsa.phr.data.ccda;

public class MedicationDispense
{
	private java.time.LocalDateTime dispensedDate = null;
	public final java.time.LocalDateTime getDispensedDate()
	{
		return dispensedDate;
	}
	public final void setDispensedDate(java.time.LocalDateTime value)
	{
		dispensedDate = value;
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

	private ContactInformation prescriptionFilledBy;
	public final ContactInformation getPrescriptionFilledBy()
	{
		return prescriptionFilledBy;
	}
	public final void setPrescriptionFilledBy(ContactInformation value)
	{
		prescriptionFilledBy = value;
	}
}