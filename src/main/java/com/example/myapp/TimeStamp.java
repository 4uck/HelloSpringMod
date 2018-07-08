package com.example.myapp;

//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import javax.persistence.*;

//@Entity
//@Table(name = "timestamps")
//public final class TimeStamp {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private int timepermil;
//    private int state;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="account_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Account account;
//
//    public TimeStamp() {
//    }
//
//    public TimeStamp(final int timepermil, final int state) {
//        this.timepermil = timepermil;
//        this.state = state;
//    }
//
//    public int getTimepermil() {
//        return timepermil;
//    }
//
//    public void setTimepermil(int timepermil) {
//        this.timepermil = timepermil;
//    }
//
//    public int getState() {
//        return state;
//    }
//
//    public void setState(int state) {
//        this.state = state;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//}
