package com.example.loginrelative;

import android.app.Application;

import com.example.loginrelative.modelo.User;

/**
 * Created by usuario on 6/10/16.
 */

public class LogInApplication extends Application {
    public LogInApplication() {

    }
    private  User user;
    public User getUser() {
        return user;
    }
    public User setUser(User user){
        return user;
    }
    public LogInApplication(User user) {
        this.user = user;
    }
    @Override
    public void onCreate()
    {
        super.onCreate();
    }
}
