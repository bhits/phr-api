package gov.samhsa.mhc.phr.domain.patient;


import gov.samhsa.mhc.phr.domain.reference.AdministrativeGenderCode;
import gov.samhsa.mhc.phr.domain.valueobject.Address;
import gov.samhsa.mhc.phr.domain.valueobject.Telephone;
import org.hibernate.envers.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"),
        indexes = @Index(columnList = "email", name = "email_idx", unique = true))
@Audited
public class Patient {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** The first name. */
    @NotNull
    @Size(min = 2, max = 30)
    @Pattern(regexp ="^[a-zA-ZÀ-ÿ ]*$", message = "The First Name contains invalid characters. Please try again.")
    private String firstName;

    /** The last name. */
    @NotNull
    @Size(min = 2, max = 30)
    @Pattern(regexp ="^[a-zA-ZÀ-ÿ ]*$", message = "The Last Name contains invalid characters. Please try again.")
    private String lastName;

    /** The birth day. */
    @Past
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthDay;

    /** The administrative gender code. */
    @ManyToOne(cascade = CascadeType.ALL)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private AdministrativeGenderCode administrativeGenderCode;

    /** The email. */
    @Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([a-z0-9-]+(\\.[a-z0-9-]+)*?\\.[a-z]{2,6}|(\\d{1,3}\\.){3}\\d{1,3})(:\\d{4})?$")
    private String email;

    @Size(max = 30)
    private String medicalRecordNumber;

    /** The patient id number. */
    @Size(max = 255)
    private String enterpriseIdentifier;

    /** The patient id number. */
    @Size(max = 255)
    private String resourceIdentifier;

    /** The address. */
    @Embedded
    @AuditOverrides(value = {
            @AuditOverride(name = "streetAddressLine", isAudited = true),
            @AuditOverride(name = "city", isAudited = true),
            @AuditOverride(name = "stateCode", isAudited = true),
            @AuditOverride(name = "postalCode", isAudited = true) })
    private Address address;

    /** The telephone. */
    @Embedded
    @AuditOverride(name = "telephone", isAudited = true)
    private Telephone telephone;

    /** The username. */
    private String username;
    /** The social security number. */
    @Pattern(regexp = "(\\d{3}-?\\d{2}-?\\d{4})*")
    private String socialSecurityNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public AdministrativeGenderCode getAdministrativeGenderCode() {
        return administrativeGenderCode;
    }

    public void setAdministrativeGenderCode(AdministrativeGenderCode administrativeGenderCode) {
        this.administrativeGenderCode = administrativeGenderCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getMedicalRecordNumber() {
        return medicalRecordNumber;
    }

    public void setMedicalRecordNumber(String medicalRecordNumber) {
        this.medicalRecordNumber = medicalRecordNumber;
    }

    public String getEnterpriseIdentifier() {
        return enterpriseIdentifier;
    }

    public void setEnterpriseIdentifier(String enterpriseIdentifier) {
        this.enterpriseIdentifier = enterpriseIdentifier;
    }

    public String getResourceIdentifier() {
        return resourceIdentifier;
    }

    public void setResourceIdentifier(String resourceIdentifier) {
        this.resourceIdentifier = resourceIdentifier;
    }
}
