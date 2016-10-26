package com.example.loginrelative;

/**
 * Created by usuario on 6/10/16.
 */

public interface IloginMvp {
     int DATA_EMPTY = 4;
     int PASSWORD_DIGIT = 1;
     int PASSWORD_CASE = 2;
     int PASSWORD_LENGHT = 3;

    interface  View{
        public void setMessageError(String Error);
    }

    interface Presenter{
        public void validateCredentials(String user,String password);
    }
}
