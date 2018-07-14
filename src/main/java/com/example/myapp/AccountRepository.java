package com.example.myapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    public boolean existsByUsername(String username);

    public Account findByUsername(String username);
}
