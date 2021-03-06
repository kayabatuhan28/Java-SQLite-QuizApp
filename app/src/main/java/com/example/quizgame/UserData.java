package com.example.quizgame;

public class UserData {
    private int id;
    private String username;
    private String password;
    private String email;
    private int degisikmax;
    private int bilgimax;

    public UserData(int id, String username, String password, String email, int degisikmax, int bilgimax) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.degisikmax = degisikmax;
        this.bilgimax = bilgimax;
    }

    public UserData(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDegisikmax() {
        return degisikmax;
    }

    public void setDegisikmax(int degisikmax) {
        this.degisikmax = degisikmax;
    }

    public int getBilgimax() {
        return bilgimax;
    }

    public void setBilgimax(int bilgimax) {
        this.bilgimax = bilgimax;
    }
}
