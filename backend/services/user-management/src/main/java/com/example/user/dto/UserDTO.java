package com.example.user.dto;

public class UserDTO {

    private String id;
    private String username;
    private String password;
    private String surname;
    private String lastname;
    private String email;

    public UserDTO() {
    }

    public UserDTO(String id, String username, String password, String surname, String lastname, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.surname = surname;
        this.lastname = lastname;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public void setEmail(String mail) {
        this.email = email;
    }
}
