package com.example.loginrelative;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LogInRelative extends AppCompatActivity implements IloginMvp.View{
    private IloginMvp.Presenter loginMvp;
    private EditText edtPassword;
    private EditText edtUser;
    private Button btnOk;
    private Button btnCancel;
    private final  String TAG="com.exaple.loginrelative";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_relative);
        loginMvp = new LogInPresenter(this);
        edtPassword = (EditText) findViewById(R.id.edtPass);
        edtUser = (EditText) findViewById(R.id.edtUser);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginMvp.validateCredentials(edtUser.getText().toString(),edtPassword.getText().toString());
            }
        });
        if (((LogInApplication)getApplicationContext()).getUser () != null)
            Log.d("TAG",((LogInApplication)getApplicationContext()).getUser ().toString());
    }

    @Override
    public void setMessageError(String error) {
        edtPassword.setError(error);
    }
}
