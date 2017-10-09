package com.optus.jneto.uitest;

/**
 * Created by jneto on 10/8/17.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {

    private static final String ARG_FRAGMENT_NUMBER = "fragment_number";

    OnFragmentTappedListener mCallback;

    public interface OnFragmentTappedListener {
        void onFragmentTapped(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnFragmentTappedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentTappedListener");
        }
    }

    public MainFragment() {
    }

    public static MainFragment newInstance(int fragmentNumber) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_FRAGMENT_NUMBER, fragmentNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.fragment_label);
        textView.setText(getString(R.string.fragment_format, getArguments().getInt(ARG_FRAGMENT_NUMBER)));
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onFragmentTapped(getArguments().getInt(ARG_FRAGMENT_NUMBER));
            }
        });

        return rootView;
    }
}
