package com.example.myapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The class describes the interaction with account table into postgres.
 * @author Monin
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * The method checks the existence of the user
     * @param username user's name
     * @return if user exist then return true, else return false
     */
    public boolean existsByUsername(String username);

    /**
     *
     * @param username user's name
     * @return {@link Account} by name
     */
    public Account findByUsername(String username);
}
