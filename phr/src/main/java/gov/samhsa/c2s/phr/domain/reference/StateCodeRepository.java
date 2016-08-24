package gov.samhsa.c2s.phr.domain.reference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by sadhana.chandra on 12/14/2015.
 */
@Repository
public interface StateCodeRepository extends JpaSpecificationExecutor<StateCode>, JpaRepository<StateCode,Long>{
    public abstract StateCode findByCode(String code);
}
