package com.barranquero.loginrelative;

import android.app.Application;

import com.barranquero.loginrelative.model.User;

/**
 * Class which stores a User in the Application class
 */
public class LoginRelative_Application extends Application {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
