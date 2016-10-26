package com.example.loginrelative.modelo;

/**
 * Created by usuario on 6/10/16.
 */

public class User {
    public User (String user, String password){
        this.user = user;
        this.password = password;
    }
    private String user;
    private String password;
    public String getPassword() {
        return password;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user, String password) {
        this.user = user;
    }
    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
