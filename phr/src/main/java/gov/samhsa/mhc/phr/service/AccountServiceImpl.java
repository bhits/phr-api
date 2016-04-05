package gov.samhsa.mhc.phr.service;

import gov.samhsa.mhc.phr.aspect.ExceptionLoggingAspects;
import gov.samhsa.mhc.phr.domain.patient.Patient;
import gov.samhsa.mhc.phr.domain.patient.PatientRepository;
import gov.samhsa.mhc.phr.domain.reference.AdministrativeGenderCodeRepository;
import gov.samhsa.mhc.phr.domain.reference.StateCode;
import gov.samhsa.mhc.phr.domain.reference.StateCodeRepository;
import gov.samhsa.mhc.phr.domain.valueobject.Address;
import gov.samhsa.mhc.phr.domain.valueobject.Telephone;
import gov.samhsa.mhc.phr.service.dto.PatientDto;
import gov.samhsa.mhc.phr.service.dto.PatientListDto;
import gov.samhsa.mhc.phr.service.dto.SignupDto;
import gov.samhsa.mhc.phr.service.exception.PatientNotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AdministrativeGenderCodeRepository administrativeGenderCodeRepository;

    @Autowired
    private StateCodeRepository stateCodeRepository;

    @Autowired
    private ModelMapper modelMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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

        // map signupDTO to patient
        CopySignupDtoToPatient(signupDto,patient);

        //update identifiers
        addIdentifiers(signupDto, patient);

        patient = patientRepository.save(patient);

        return signupDto;
    }

    @Override
    public PatientListDto findAllPatientsInPage(String pageNumber) {
        List<PatientDto> patientDtoList = new ArrayList<PatientDto>() ;
        PageRequest page = new PageRequest(Integer.parseInt(pageNumber), 10, Sort.Direction.DESC, "id");
        final Page<Patient> pages =  patientRepository.findAll(page);

        if (pages != null) {
            patientDtoList = patientListToPatientDtoList(pages.getContent());
        }else{
            logger.error("No pages found for current page: " + pageNumber);
        }
        PatientListDto patientListDto = new PatientListDto();
        patientListDto.setPatientList(patientDtoList);
        patientListDto.setCurrentPage(pages.getNumber());
        patientListDto.setTotalItems(pages.getTotalElements());
        patientListDto.setTotalPages(pages.getTotalPages());
        patientListDto.setItemsPerPage(pages.getSize());

        return patientListDto;
    }

    @Override
    public List<PatientDto> findAllPatientByFirstNameAndLastName(StringTokenizer tokenizer) {

        List<Patient> patients;
        if (tokenizer.countTokens() == 1) {
            String firstName = tokenizer.nextToken(); // First Token is the first name
            patients = patientRepository.findAllTopTenByFirstNameLikesAndLastNameLikes("%" + firstName+ "%");
        } else if (tokenizer.countTokens() >= 2) {
            String firstName = tokenizer.nextToken(); // First Token is the first name
            String lastName = tokenizer.nextToken();  // Last Token is the first name
            patients = patientRepository.findAllTopTenByFirstNameLikesAndLastNameLikes("%" + firstName+ "%", "%" + lastName + "%");
        } else {
            patients = new ArrayList<Patient>();
        }
        return patientListToPatientDtoList(patients);
    }


    public Patient convertToPatient(SignupDto signupDto) {
        Patient patient = new Patient();
        CopySignupDtoToPatient(signupDto, patient);

        return patient;
    }

    private void CopySignupDtoToPatient(SignupDto signupDto, Patient patient) {
        patient.setLastName(signupDto.getLastName());
        patient.setFirstName(signupDto.getFirstName());
        patient.setSocialSecurityNumber(signupDto.getSocialSecurityNumber());
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
        StateCode stateCode = stateCodeRepository.findByCode(signupDto.getStateCode());
        address.setStateCode(stateCode);
        address.setPostalCode(signupDto.getZip());
        patient.setAddress(address);
    }

    private void addIdentifiers(SignupDto signupDto, Patient patient) {
        patient.setId(signupDto.getId());
        patient.setMedicalRecordNumber(signupDto.getMedicalRecordNumber());
        patient.setResourceIdentifier(signupDto.getResourceIdentifier());
        patient.setEnterpriseIdentifier(signupDto.getEnterpriseIdentifier());
    }


    private List<PatientDto> patientListToPatientDtoList(List<Patient> listOfPatient){
        List<PatientDto> patientDtoList = new ArrayList<PatientDto>() ;
        for (Patient patient : listOfPatient) {
            PatientDto patientDto = modelMapper.map(patient, PatientDto.class);
            patientDtoList.add(patientDto);
        }
        return patientDtoList;
    }
}
