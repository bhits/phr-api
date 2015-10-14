package gov.samhsa.phr.data.IExHub;

public class InfoExHubServiceRequestDto
{
	private String enterpriseMasterRecordNumber;
	public final String getEnterpriseMasterRecordNumber()
	{
		return enterpriseMasterRecordNumber;
	}
	public final void setEnterpriseMasterRecordNumber(String value)
	{
		enterpriseMasterRecordNumber = value;
	}

	private String firstName;
	public final String getFirstName()
	{
		return firstName;
	}
	public final void setFirstName(String value)
	{
		firstName = value;
	}

	private String lastName;
	public final String getLastName()
	{
		return lastName;
	}
	public final void setLastName(String value)
	{
		lastName = value;
	}

	private String middleName;
	public final String getMiddleName()
	{
		return middleName;
	}
	public final void setMiddleName(String value)
	{
		middleName = value;
	}

	private java.time.LocalDateTime dateOfBirth = java.time.LocalDateTime.MIN;
	public final java.time.LocalDateTime getDateOfBirth()
	{
		return dateOfBirth;
	}
	public final void setDateOfBirth(java.time.LocalDateTime value)
	{
		dateOfBirth = value;
	}

	private String patientGender;
	public final String getPatientGender()
	{
		return patientGender;
	}
	public final void setPatientGender(String value)
	{
		patientGender = value;
	}

	private String motherMaidenName;
	public final String getMotherMaidenName()
	{
		return motherMaidenName;
	}
	public final void setMotherMaidenName(String value)
	{
		motherMaidenName = value;
	}

	private java.time.LocalDateTime startDate = java.time.LocalDateTime.MIN;
	public final java.time.LocalDateTime getStartDate()
	{
		return startDate;
	}
	public final void setStartDate(java.time.LocalDateTime value)
	{
		startDate = value;
	}

	private java.time.LocalDateTime endDate = java.time.LocalDateTime.MIN;
	public final java.time.LocalDateTime getEndDate()
	{
		return endDate;
	}
	public final void setEndDate(java.time.LocalDateTime value)
	{
		endDate = value;
	}
}