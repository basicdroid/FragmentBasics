package com.training.android.fragmentbasics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputFragment extends Fragment implements View.OnClickListener {

    private OnCreateMemeListener mOnCreateMemeListener;

    private EditText mEtTop;
    private EditText mEtBelow;

    public interface OnCreateMemeListener {
        void onCreateMeme(String top, String below);
    }

    public void setOnCreateMemeListener(OnCreateMemeListener onCreateMemeListener) {
        mOnCreateMemeListener = onCreateMemeListener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        mEtTop = (EditText) view.findViewById(R.id.etTopText);
        mEtBelow = (EditText) view.findViewById(R.id.etBelowText);

        Button btnCreateMeme = (Button) view.findViewById(R.id.btnCreateMeme);
        btnCreateMeme.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (mOnCreateMemeListener == null) {
            mOnCreateMemeListener = (OnCreateMemeListener) getActivity();

            if (mOnCreateMemeListener == null)
                throw new RuntimeException("Activity where InputFragment is contained should " +
                        "implement InputFragment.OnCreateMemeListener.");
        }

        String top = mEtTop.getText().toString();
        String below = mEtBelow.getText().toString();
        mOnCreateMemeListener.onCreateMeme(top, below);
    }
}
