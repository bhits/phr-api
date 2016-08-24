package gov.samhsa.c2s.phr.domain.patient;

import gov.samhsa.c2s.phr.domain.reference.AdministrativeGenderCode;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by sadhana.chandra on 12/14/2015.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    /**
     * Find all by first name likes and last name likes.
     *
     * @param token1 the token1
     * @return the list
     */
    @Query("select p from Patient p where p.firstName like ?1 or p.lastName like ?1")
    public abstract List<Patient> findAllByFirstNameLikesAndLastNameLikes(String token1, Pageable pageRequest);

    /**
     * Find all by first name likes and last name likes.
     *
     * @param token1 the token1
     * @param token2 the token2
     * @return the list
     */
    @Query("select p from Patient p where (p.firstName like ?1 or p.firstName like ?2) and (p.lastName like ?1 or p.lastName like ?2)")
    public abstract List<Patient> findAllByFirstNameLikesAndLastNameLikes(String token1, String token2, Pageable pageRequest);

    public abstract List<Patient> findAllByFirstNameAndLastNameAndBirthDayAndAdministrativeGenderCode(String firstName, String lastName, Date birthDay,
                                                                                                   AdministrativeGenderCode administrativeGenderCode);

    Optional<Patient> findOneByEmail(String email);
}
