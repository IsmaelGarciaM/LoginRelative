package com.barranquero.loginrelative;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * This application uses the Model-View-Presenter philosophy
 * Class which shows a Login Activity in a RelativeLayout
 * @author José Antonio Barranquero Fernández
 * @version 1.0
 */
public class LoginRelative_Activity extends AppCompatActivity implements ILoginMvp.View {

    private ILoginMvp.Presenter mLoginMvp;
    private EditText mEdtPassword;
    private EditText mEdtUser;
    private Button mBtnOk;
    private Button mBtnCancel;
    private final String TAG = "LoginRelative_Activity";

    /**
     * Method which initialises and shows the Activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_relative);

        mLoginMvp = new LoginRelative_Presenter(this);  // The Presenter has an Activity instance

        mEdtUser = (EditText)findViewById(R.id.edtUser);
        mEdtPassword = (EditText)findViewById(R.id.edtPassword);

        mBtnOk = (Button)findViewById(R.id.btnOK);
        mBtnOk.setOnClickListener(new android.view.View.OnClickListener(){
            @Override
            public void onClick(android.view.View view) {
                String user = mEdtUser.getText().toString();
                String password = mEdtPassword.getText().toString();
                mLoginMvp.validateCredentials(user, password);
            }
        });

        mBtnCancel = (Button)findViewById(R.id.btnCancel);
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetValues();
            }
        });

        // Checking the persistence of the Application object
        if (((LoginRelative_Application)this.getApplicationContext()).getUser() != null)
            Log.d(TAG, ((LoginRelative_Application)this.getApplicationContext()).getUser().toString());
    }

    /**
     * Method which clears both the user and password fields
     */
    private void resetValues() {
        mEdtUser.setText("");
        mEdtPassword.setText("");
    }

    /**
     * Method which shows an error to the user
     * @param error The string which explains the occurred error
     */
    @Override
    public void setMessageError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Finalised Activity");
    }
}
