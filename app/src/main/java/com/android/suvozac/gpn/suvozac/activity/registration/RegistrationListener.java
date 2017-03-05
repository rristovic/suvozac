package com.android.suvozac.gpn.suvozac.activity.registration;


import android.os.Bundle;


public interface RegistrationListener {

    /**
     * Called when fragment needs to proceed with registration.
     * @param params parameters that are required to proceed with registration.
     */
    void onProceed(Bundle params);

    /**
     * Called when user hits back and wants to go step back with registration process.
     */
    void onStepBack();

    /**
     * Called when user hits stop button.
     */
    void onStopRegistration();


    // Bundle parameters that are sent to RegisterActivity for registration process
     String PARAM_FRAG_NAME = "fragment_name";
     String PARAM_EMAIL = "email_param";
     String PARAM_PASS = "password_param";
     String PARAM_FIRST_NAME = "first_name_param";
    String PARAM_LAST_NAME = "last_name_param";
    String PARAM_BIRTHDAY = "birthday";
    String PARAM_GENDER = "gender";
    String PARAM_PHONE_NUM = "phone_number";
}
