package gov.samhsa.mhc.phr.service;

import gov.samhsa.mhc.phr.domain.patient.Patient;
import gov.samhsa.mhc.phr.domain.patient.PatientRepository;
import gov.samhsa.mhc.phr.domain.reference.AdministrativeGenderCodeRepository;
import gov.samhsa.mhc.phr.domain.valueobject.Address;
import gov.samhsa.mhc.phr.domain.valueobject.Telephone;
import gov.samhsa.mhc.phr.service.dto.PatientDto;
import gov.samhsa.mhc.phr.service.dto.SignupDto;
import gov.samhsa.mhc.phr.service.exception.PatientNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AdministrativeGenderCodeRepository administrativeGenderCodeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean checkduplicatePatient(SignupDto signupDto) {
        Patient patient = convertToPatient(signupDto);
        //find patient by lastname firstname
        return false;

    }

    @Override
    public SignupDto createPatient(SignupDto signupDto){
        Patient patient = convertToPatient(signupDto);
        patient = patientRepository.save(patient);
        signupDto.setId(patient.getId());
        return signupDto;
    }

    @Override
    public PatientDto findPatientById(long id) {
        final Patient patient = Optional.ofNullable(patientRepository.findOne(id)).orElseThrow(PatientNotFoundException::new);
        return modelMapper.map(patient, PatientDto.class);
    }

    @Override
    public SignupDto updatePatient(SignupDto signupDto, long id) {

        //TODO : verify if id and signupDto.getId() are same
        // Patient patient = convertToPatient(signupDto, false);
        Patient patient = Optional.ofNullable(patientRepository.findOne(id)).orElseThrow(PatientNotFoundException::new);
        //update identifiers
        addIdentifiers(signupDto, patient);
        patient = patientRepository.save(patient);
        return signupDto;
    }


    public Patient convertToPatient(SignupDto signupDto) {
        Patient patient = new Patient();

        patient.setLastName(signupDto.getLastName());
        patient.setFirstName(signupDto.getFirstName());
        patient.setUsername(signupDto.getUsername());
        patient.setSocialSecurityNumber(signupDto.getSsn());
        patient.setEmail(signupDto.getEmail());
        patient.setBirthDay(signupDto.getBirthDate());

        if (StringUtils.hasText(signupDto.getGenderCode())) {
            patient.setAdministrativeGenderCode(administrativeGenderCodeRepository
                    .findByCode(signupDto.getGenderCode()));
        }

        //TODO: set DOB , sex, telephone
        Telephone telephone = new Telephone();
        telephone.setTelephone(signupDto.getTelephone());
        patient.setTelephone(telephone);

        //setup address
        Address address = new Address();
        address.setStreetAddressLine(signupDto.getAddress());
        address.setCity(signupDto.getCity());
        //TODO: setup state code
        address.setPostalCode(signupDto.getZip());
        patient.setAddress(address);

        return patient;
    }

    private void addIdentifiers(SignupDto signupDto, Patient patient) {
        patient.setId(signupDto.getId());
        patient.setMedicalRecordNumber(signupDto.getMedicalRecordNumber());
        patient.setResourceIdentifier(signupDto.getResourceIdentifier());
        patient.setEnterpriseIdentifier(signupDto.getEnterpriseIdentifier());
    }
}
