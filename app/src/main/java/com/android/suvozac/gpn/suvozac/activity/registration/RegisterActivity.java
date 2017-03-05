package com.android.suvozac.gpn.suvozac.activity.registration;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.suvozac.gpn.suvozac.R;

public class RegisterActivity extends AppCompatActivity implements RegistrationListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        EmailFragment fragment = new EmailFragment();
        fragmentTransaction.add(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onProceed(Bundle params) {

    }

    @Override
    public void onStepBack() {

    }

    @Override
    public void onStopRegistration() {

    }
}
