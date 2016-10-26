package com.example.loginrelative;

import android.content.Context;
import android.text.TextUtils;

import com.example.loginrelative.modelo.User;

import java.util.regex.Pattern;

/**
 * Created by usuario on 6/10/16.
 */

public class LogInPresenter implements IloginMvp.Presenter {

    private IloginMvp.View view;

    public LogInPresenter(IloginMvp.View view) {
        this.view = view;
    }

    @Override
    public void validateCredentials(String user, String password) {
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(password))
            // cojo el contexto y lo recojo desde data empty
            view.setMessageError(((Context)view).getResources().getString(R.string.data_empty));
        else if (!Pattern.matches(".*[0-9].*",password))
            //Ejecuto el metodo de la vista
            view.setMessageError(((Context)view).getResources().getString(R.string.no_digit));

        else if (!Pattern.matches(".*[a-z].*",password)||!Pattern.matches(".*[A-Z].*",password))
            view.setMessageError(((Context)view).getResources().getString(R.string.no_mayusc));

        else if (password.length() < 8)
            view.setMessageError(((Context)view).getResources().getString(R.string.length));
        else{
            //Guardar usuario en la clase application
            (( LogInApplication)((Context)view).getApplicationContext()).setUser(new User(user,password));

        }

    }
}
