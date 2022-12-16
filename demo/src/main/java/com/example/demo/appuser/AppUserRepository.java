package com.example.demo.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * This class will enable the user by performing a JPQL query to the db
 * @Modifying perform INSERT, UPDATE, DELETE, etc.
 * @Query JPQL expression
 * @Transactional on a method of a class with @Transactional(readOnly = true) no data gets written to the database,
 * whereas with {@Transactional} the data gets written to the database.
 */
@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a " + "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
}
