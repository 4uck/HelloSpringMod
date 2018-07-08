package com.example.myapp;

import javax.persistence.*;
import java.util.List;

/**
 * Specification user collection into mongodb.
 */
@Entity
@Table(name = "accounts")
public final class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String password;

    @ElementCollection
    @CollectionTable(name="Timestamps")
    @Column(name="timestamp")
    List<Long> timestamps;

    public Account() {
    }

    public Account(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

//    public Account(String login, String password, List<TimeStamp> timestamp) {
//        this.login = login;
//        this.password = password;
//        this.timestamp = timestamp;
//    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Long> getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(List<Long> timestamps) {
        this.timestamps = timestamps;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
