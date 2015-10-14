package gov.samhsa.phr.data.ccda;

import java.util.*;

public class DemographicInformation
{
	private List<PersonName> names;
	public final List<PersonName> getNames()
	{
		return names;
	}
	public final void setNames(List<PersonName> value)
	{
		names = value;
	}

	private CodedConcept administrativeGender;
	public final CodedConcept getAdministrativeGender()
	{
		return administrativeGender;
	}
	public final void setAdministrativeGender(CodedConcept value)
	{
		administrativeGender = value;
	}

	private String patientIdentifier;
	public final String getPatientIdentifier()
	{
		return patientIdentifier;
	}
	public final void setPatientIdentifier(String value)
	{
		patientIdentifier = value;
	}

	private List<ContactInformation> contacts;
	public final List<ContactInformation> getContacts()
	{
		return contacts;
	}
	public final void setContacts(List<ContactInformation> value)
	{
		contacts = value;
	}

	private CodedConcept codedConcept;
	public final CodedConcept getMaritalStatus()
	{
		return codedConcept;
	}
	public final void setMaritalStatus(CodedConcept value)
	{
		codedConcept = value;
	}

	private CodedConcept race;
	public final CodedConcept getRace()
	{
		return race;
	}
	public final void setRace(CodedConcept value)
	{
		race = value;
	}

	private java.time.LocalDateTime birthDate = null;
	public final java.time.LocalDateTime getBirthDate()
	{
		return birthDate;
	}
	public final void setBirthDate(java.time.LocalDateTime value)
	{
		birthDate = value;
	}

	private CodedConcept religion;
	public final CodedConcept getReligion()
	{
		return religion;
	}
	public final void setReligion(CodedConcept value)
	{
		religion = value;
	}

	private String guardian;
	public final String getGuardian()
	{
		return guardian;
	}
	public final void setGuardian(String value)
	{
		guardian = value;
	}

	private CodedConcept ethnicity;
	public final CodedConcept getEthnicity()
	{
		return ethnicity;
	}
	public final void setEthnicity(CodedConcept value)
	{
		ethnicity = value;
	}

	private List<CodedConcept> languages;
	public final List<CodedConcept> getLanguages()
	{
		return languages;
	}
	public final void setLanguages(List<CodedConcept> value)
	{
		languages = value;
	}
}