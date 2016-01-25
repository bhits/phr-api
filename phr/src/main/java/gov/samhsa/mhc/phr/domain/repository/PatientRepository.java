package gov.samhsa.mhc.phr.domain.repository;

import gov.samhsa.mhc.phr.domain.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sadhana.chandra on 12/14/2015.
 */
@Repository
public interface  PatientRepository extends JpaRepository<Patient,Long>{
}
