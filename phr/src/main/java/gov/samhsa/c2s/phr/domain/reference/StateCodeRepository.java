package gov.samhsa.c2s.phr.domain.reference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StateCodeRepository extends JpaSpecificationExecutor<StateCode>, JpaRepository<StateCode, Long> {
    StateCode findByCode(String code);
}
