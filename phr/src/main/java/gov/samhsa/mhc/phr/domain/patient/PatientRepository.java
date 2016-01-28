package gov.samhsa.mhc.phr.domain.patient;

import gov.samhsa.mhc.phr.domain.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sadhana.chandra on 12/14/2015.
 */
@Repository
public interface  PatientRepository extends JpaRepository<Patient,Long>{
}
