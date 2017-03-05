package com.android.suvozac.gpn.suvozac.activity.registration;

import android.app.Fragment;
import android.content.Context;


public abstract class RregistrationFragment extends Fragment {

    protected RegistrationListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof RegistrationListener) {
            mListener = (RegistrationListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
