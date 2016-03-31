package gov.samhsa.mhc.phr.domain.patient;

import gov.samhsa.mhc.phr.domain.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sadhana.chandra on 12/14/2015.
 */
@Repository
public interface  PatientRepository extends JpaRepository<Patient,Long>{
    /**
     * Find all by first name likes and last name likes.
     *
     * @param token1
     *            the token1
     * @return the list
     */
    @Query("select p from Patient p where p.firstName like ?1 or p.lastName like ?1")
    public abstract List<Patient> findAllTopTenByFirstNameLikesAndLastNameLikes(String token1);

    /**
     * Find all by first name likes and last name likes.
     *
     * @param token1
     *            the token1
     * @param token2
     *            the token2
     * @return the list
     */
    @Query("select p from Patient p where (p.firstName like ?1 or p.firstName like ?2) and (p.lastName like ?1 or p.lastName like ?2)")
    public abstract List<Patient> findAllTopTenByFirstNameLikesAndLastNameLikes(String token1, String token2);
}
