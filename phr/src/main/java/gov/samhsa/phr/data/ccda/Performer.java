package gov.samhsa.phr.data.ccda;

public class Performer
{
	private String typeCode;
	public final String getTypeCode()
	{
		return typeCode;
	}
	public final void setTypeCode(String value)
	{
		typeCode = value;
	}

	private FunctionCode functionCode;
	public final FunctionCode getFunctionCode()
	{
		return functionCode;
	}
	public final void setFunctionCode(FunctionCode value)
	{
		functionCode = value;
	}

	private java.time.LocalDateTime timeLow = null;
	public final java.time.LocalDateTime getTimeLow()
	{
		return timeLow;
	}
	public final void setTimeLow(java.time.LocalDateTime value)
	{
		timeLow = value;
	}

	private java.time.LocalDateTime timeHigh = null;
	public final java.time.LocalDateTime getTimehigh()
	{
		return timeHigh;
	}
	public final void setTimehigh(java.time.LocalDateTime value)
	{
		timeHigh = value;
	}

	private RepresentedOrganization representedOrganization;
	public final RepresentedOrganization getRepresentedOrganization()
	{
		return representedOrganization;
	}
	public final void setRepresentedOrganization(RepresentedOrganization value)
	{
		representedOrganization = value;
	}

	private AssignedEntity assignedEntity;
	public final AssignedEntity getAssignedEntity()
	{
		return assignedEntity;
	}
	public final void setAssignedEntity(AssignedEntity value)
	{
		assignedEntity = value;
	}

}