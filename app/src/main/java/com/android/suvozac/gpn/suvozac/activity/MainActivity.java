package com.android.suvozac.gpn.suvozac.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.suvozac.gpn.suvozac.R;
import com.android.suvozac.gpn.suvozac.activity.registration.RegisterActivity;
import com.android.suvozac.gpn.suvozac.internet.SessionManager;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnProceed, btnReg;

    private SessionManager mSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setClickListeners();
    }


    private void init() {
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnProceed = (Button) findViewById(R.id.btnRegProceed);
        btnReg = (Button) findViewById(R.id.btnReg);

        mSessionManager = SessionManager.getInstance(this);

    }

    private void setClickListeners() {
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
                mSessionManager.registerUser(etEmail.getText().toString(),
                        etPassword.getText().toString(), "Radovan", "Ristovic");
            }
        });

        findViewById(R.id.btnReg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(i);
            }
        });
    }

    /**
     * Helper method for validating data in fields.
     */
    private void validateData() {

    }
}
