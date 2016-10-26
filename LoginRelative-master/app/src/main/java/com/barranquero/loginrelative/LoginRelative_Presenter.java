package com.barranquero.loginrelative;


import android.content.Context;
import android.text.TextUtils;

import com.barranquero.loginrelative.model.User;

/**
 * Class that controls the view and implements the Login rules
 *  - At least one upper case and one lower case character
 *  - At least one digit
 *  - At least 8 characters long
 * @author José Antonio Barranquero Fernández
 * @version 1.0
 */
public class LoginRelative_Presenter implements ILoginMvp.Presenter {

    private ILoginMvp.View view;

    public LoginRelative_Presenter(ILoginMvp.View view) {
        this.view = view;
    }

    /**
     * Method which checks whether the password the user has entered complies with the rules and saves the username and password
     * @param user The username entered in the username field
     * @param password The password entered in the password field
     */
    @Override
    public void validateCredentials(String user, String password) {
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(password))
            view.setMessageError(((Context)view).getResources().getString(R.string.data_empty));
        else {
            if (!(password.matches("(.*)\\d(.*)")))
                view.setMessageError(((Context)view).getResources().getString(R.string.password_digit));
            if (!(password.matches("(.*)\\p{Lower}(.*)") && password.matches("(.*)\\p{Upper}(.*)")))
                view.setMessageError(((Context)view).getResources().getString(R.string.password_case));
            if (password.length() < 8)
                view.setMessageError(((Context)view).getResources().getString(R.string.password_length));
            else {
                // We save the user in the Application class
                ((LoginRelative_Application)((Context)view).getApplicationContext()).setUser(new User(user,password));
            }
        }
    }
}
