package com.android.suvozac.gpn.suvozac.activity.registration;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.suvozac.gpn.suvozac.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistrationListener} interface
 * to handle interaction events.
 * Use the {@link NameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NameFragment extends RregistrationFragment {
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

    public NameFragment() {
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
    public static NameFragment newInstance(String param1, String param2) {
        NameFragment fragment = new NameFragment();
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

        // Adding input fields
        Context c = getContext();
        // Add layout holder
        LinearLayout holder = new LinearLayout(c);
        holder.setOrientation(LinearLayout.HORIZONTAL);
        RelativeLayout.LayoutParams llParam = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        llParam.addRule(RelativeLayout.CENTER_IN_PARENT);
        holder.setLayoutParams(llParam);
        // Add edit text
        final EditText etFirstName = new EditText(getContext());
        etFirstName.setHint("Ime");
        final EditText etLastName = new EditText(getContext());
        etLastName.setHint("Prezime");
        LinearLayout.LayoutParams etParam = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        etParam.weight = 1;
        etFirstName.setLayoutParams(etParam);
        etLastName.setLayoutParams(etParam);
        // Add vies to layout
        rootView.addView(holder);

        // Set label
        tvLabel = (TextView) rootView.findViewById(R.id.tvLabel);
        tvLabel.setText("Unesite vase ime i prezime kako biste nam popusili kurac kasnije jos jednom");

        // Set proceed button
        btnRegProceed = (Button)rootView.findViewById(R.id.btnRegProceed);
        btnRegProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString(RegistrationListener.PARAM_FRAG_NAME, NameFragment.class.getSimpleName());
                b.putString(RegistrationListener.PARAM_FIRST_NAME, etFirstName.getText().toString());
                b.putString(RegistrationListener.PARAM_LAST_NAME, etLastName.getText().toString());
                mListener.onProceed(b);
            }
        });

        return rootView;
    }
}
