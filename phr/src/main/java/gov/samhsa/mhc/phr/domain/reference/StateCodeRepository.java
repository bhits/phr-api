package gov.samhsa.mhc.phr.domain.reference;

import gov.samhsa.mhc.phr.domain.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sadhana.chandra on 12/14/2015.
 */
@Repository
public interface StateCodeRepository extends JpaSpecificationExecutor<StateCode>, JpaRepository<StateCode,Long>{
    public abstract StateCode findByCode(String code);
}
