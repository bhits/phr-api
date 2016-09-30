package gov.samhsa.c2s.phr.domain.patient;


import gov.samhsa.c2s.phr.domain.reference.AdministrativeGenderCode;
import gov.samhsa.c2s.phr.domain.valueobject.Address;
import gov.samhsa.c2s.phr.domain.valueobject.Telephone;
import lombok.Data;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.AuditOverrides;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"),
        indexes = @Index(columnList = "email", name = Patient.EMAIL_IDX, unique = true))
@Audited
@Data
public class Patient {

    public static final String EMAIL_IDX = "email_idx";

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The first name.
     */
    @NotNull
    @Size(min = 2, max = 30)
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ]+[-]?[a-zA-ZÀ-ÿ']*[a-zA-ZÀ-ÿ]$", message = "The First Name contains invalid characters. Please try again.")
    private String firstName;

    /**
     * The last name.
     */
    @NotNull
    @Size(min = 2, max = 30)
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ]+[-]?[a-zA-ZÀ-ÿ']*[a-zA-ZÀ-ÿ]$", message = "The Last Name contains invalid characters. Please try again.")
    private String lastName;

    /**
     * The birth day.
     */
    @Past
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthDay;

    /**
     * The administrative gender code.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private AdministrativeGenderCode administrativeGenderCode;

    /**
     * The email.
     */
    @Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*?\\.[a-zA-Z]{2,6}|(\\d{1,3}\\.){3}\\d{1,3})(:\\d{4})?$")
    private String email;

    @Size(max = 30)
    private String medicalRecordNumber;

    /**
     * The patient id number.
     */
    @Size(max = 255)
    private String enterpriseIdentifier;

    /**
     * The patient id number.
     */
    @Size(max = 255)
    private String resourceIdentifier;

    /**
     * The address.
     */
    @Embedded
    @AuditOverrides(value = {
            @AuditOverride(name = "streetAddressLine", isAudited = true),
            @AuditOverride(name = "city", isAudited = true),
            @AuditOverride(name = "stateCode", isAudited = true),
            @AuditOverride(name = "postalCode", isAudited = true)})
    private Address address;

    /**
     * The telephone.
     */
    @Embedded
    @AuditOverride(name = "telephone", isAudited = true)
    private Telephone telephone;

    /**
     * The username.
     */
    private String username;
    /**
     * The social security number.
     */
    @Pattern(regexp = "(\\d{3}-?\\d{2}-?\\d{4})*")
    private String socialSecurityNumber;
}
