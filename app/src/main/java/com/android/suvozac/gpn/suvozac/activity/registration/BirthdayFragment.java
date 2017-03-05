package com.android.suvozac.gpn.suvozac.activity.registration;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.suvozac.gpn.suvozac.R;

import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistrationListener} interface
 * to handle interaction events.
 * Use the {@link BirthdayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BirthdayFragment extends RregistrationFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btnRegProceed ;
    private EditText etEmail;
    private TextView tvLabel;

    public BirthdayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BirthdayFragment newInstance(String param1, String param2) {
        BirthdayFragment fragment = new BirthdayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RelativeLayout rootView =  (RelativeLayout) inflater.inflate(R.layout.fragment_register, container, false);

        // Hide default input field
        etEmail = (EditText) rootView.findViewById(R.id.etInputField);
        etEmail.setVisibility(View.GONE);

        // Add date picker
        final DatePicker picker = (DatePicker) inflater.inflate(R.layout.date_picker, container, false);
        picker.setMinDate(new Date().getTime());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        picker.setLayoutParams(params);
        // Add view to layout
        rootView.addView(picker);

        // Set label
        tvLabel = (TextView) rootView.findViewById(R.id.tvLabel);
        tvLabel.setText("Unesite vas datum rodjenja kako bismo znali kada treba da vas karamo");

        // Set proceed button
        btnRegProceed = (Button)rootView.findViewById(R.id.btnRegProceed);
        btnRegProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString(RegistrationListener.PARAM_FRAG_NAME, BirthdayFragment.class.getSimpleName());
                b.putString(RegistrationListener.PARAM_BIRTHDAY,
                        Long.toString(getDateFromDatePicker(picker).getTime()));
                mListener.onProceed(b);
            }
        });

        return rootView;
    }

    private java.util.Date getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }
}
