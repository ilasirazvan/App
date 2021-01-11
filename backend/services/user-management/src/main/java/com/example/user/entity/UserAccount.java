package com.example.user.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_account")
@NamedQuery(name = "UserAccount.findUserAccountByUsername", query = "SELECT u FROM UserAccount u WHERE u.username=:username")
public class UserAccount {

    @Id
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "surname")
    private String surname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "adress")
    private String adress;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public UserAccount() {
    }

    public UserAccount(String username, String password, String surname, String lastname, String email, String adress) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.surname = surname;
        this.lastname = lastname;
        this.email = email;
        this.adress = adress;
    }
}
