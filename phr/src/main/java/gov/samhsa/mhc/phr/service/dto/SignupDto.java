package gov.samhsa.mhc.phr.service.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;

public class SignupDto
{
    @NotEmpty
    private String lastName;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String email;

    @Past
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthDate;

    @NotEmpty
    private String genderCode;

    private String ssn;
    private String telephone;
    private String address;
    private String city;
    private String state;
    private String zip;

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getSsn()
    {
        return ssn;
    }

    public void setSsn(String ssn)
    {
        this.ssn = ssn;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getGenderCode()
    {
        return genderCode;
    }

    public void setGenderCode(String genderCode)
    {
        this.genderCode = genderCode;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }


    public String getCity()
    {
        return city;

    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

}