package com.example.myapp;

import java.util.List;
import javax.persistence.*;


/**
 * Specification user collection into postgres.
 */
@Entity
@Table(name = "accounts")
public final class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @ElementCollection
    @CollectionTable(name = "Timestamps")
    @Column(name = "timestamp")
    private List<Long> timestamps;

    public Account() {
    }

    public Account(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public List<Long> getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(final List<Long> timestamps) {
        this.timestamps = timestamps;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
