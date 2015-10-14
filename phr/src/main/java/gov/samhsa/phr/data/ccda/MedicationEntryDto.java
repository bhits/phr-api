package gov.samhsa.phr.data.ccda;

import java.util.*;

public class MedicationEntryDto extends EntryBaseDto
{
	private CodedConcept drug;
	public final CodedConcept getDrug()
	{
		return drug;
	}
	public final void setDrug(CodedConcept value)
	{
		drug = value;
	}

	private String sig;
	public final String getSig()
	{
		return sig;
	}
	public final void setSig(String value)
	{
		sig = value;
	}

	private String type;
	public final String getType()
	{
		return type;
	}
	public final void setType(String value)
	{
		type = value;
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

	private java.time.LocalDateTime endDate = null;
	public final java.time.LocalDateTime getEndDate()
	{
		return endDate;
	}
	public final void setEndDate(java.time.LocalDateTime value)
	{
		endDate = value;
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

	private List<CodedConcept> indications = new ArrayList<CodedConcept>();

	public final List<CodedConcept> getIndications()
	{
		return indications;
	}
	public final void setIndications(List<CodedConcept> value)
	{
		indications = value;
	}

	private CodedConcept reaction;
	public final CodedConcept getReaction()
	{
		return reaction;
	}
	public final void setReaction(CodedConcept value)
	{
		reaction = value;
	}

	private CodedConcept route;
	public final CodedConcept getRoute()
	{
		return route;
	}
	public final void setRoute(CodedConcept value)
	{
		route = value;
	}

	private CodedConcept form;
	public final CodedConcept getForm()
	{
		return form;
	}
	public final void setForm(CodedConcept value)
	{
		form = value;
	}

	private CodedConcept bodySite;
	public final CodedConcept getBodySite()
	{
		return bodySite;
	}
	public final void setBodySite(CodedConcept value)
	{
		bodySite = value;
	}

	private CodedConcept vehicle;
	public final CodedConcept getVehicle()
	{
		return vehicle;
	}
	public final void setVehicle(CodedConcept value)
	{
		vehicle = value;
	}

	private CodedConcept preCondition;
	public final CodedConcept getPreCondition()
	{
		return preCondition;
	}
	public final void setPreCondition(CodedConcept value)
	{
		preCondition = value;
	}

	private String dispenseQuantity;
	public final String getDispenseQuantity()
	{
		return dispenseQuantity;
	}
	public final void setDispenseQuantity(String value)
	{
		dispenseQuantity = value;
	}

	private String instructions;
	public final String getInstructions()
	{
		return instructions;
	}
	public final void setInstructions(String value)
	{
		instructions = value;
	}

	private String prescribingPhysician;
	public final String getPrescribingPhysician()
	{
		return prescribingPhysician;
	}
	public final void setPrescribingPhysician(String value)
	{
		prescribingPhysician = value;
	}

	private List<MedicationDispense> dispenses = new ArrayList<MedicationDispense>();

	public final List<MedicationDispense> getDispenses()
	{
		return dispenses;
	}
	public final void setDispenses(List<MedicationDispense> value)
	{
		dispenses = value;
	}

	private List<MedicationOrder> orders = new ArrayList<MedicationOrder>();

	public final List<MedicationOrder> getOrders()
	{
		return orders;
	}
	public final void setOrders(List<MedicationOrder> value)
	{
		orders = value;
	}
}