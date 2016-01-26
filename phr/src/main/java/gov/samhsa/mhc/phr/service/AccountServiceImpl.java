package gov.samhsa.mhc.phr.service;

import gov.samhsa.mhc.phr.domain.model.Patient;
import gov.samhsa.mhc.phr.domain.repository.PatientRepository;
import gov.samhsa.mhc.phr.domain.valueobject.Address;
import gov.samhsa.mhc.phr.domain.valueobject.Telephone;
import gov.samhsa.mhc.phr.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService
{
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public boolean checkduplicatePatient(SignupDto signupDto)
    {
        Patient patient = convertToPatient(signupDto);
        //find patient by lastname firstname
       return false;

    }

    @Override
    public void createPatient(SignupDto signupDto)
    {
        Patient patient = convertToPatient(signupDto);
        patientRepository.save(patient);
    }

    public Patient convertToPatient(SignupDto signupDto){
        Patient patient=new Patient();

        patient.setLastName(signupDto.getLastName());
        patient.setFirstName(signupDto.getFirstName());
        patient.setUsername(signupDto.getUsername());
        patient.setSocialSecurityNumber(signupDto.getSsn());
        patient.setEmail(signupDto.getEmail());

        //TODO: set DOB , sex, telephone
        Telephone telephone =new Telephone();
        telephone.setTelephone(signupDto.getTelephone());
        patient.setTelephone(telephone);

        //setup address
        Address address=new Address();
        address.setStreetAddressLine(signupDto.getAddress());
        address.setCity(signupDto.getCity());
        //TODO: setup state code
        address.setPostalCode(signupDto.getZip());
        patient.setAddress(address);

        return patient;
    }
}
