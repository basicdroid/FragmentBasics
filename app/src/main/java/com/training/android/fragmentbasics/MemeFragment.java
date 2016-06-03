package com.training.android.fragmentbasics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MemeFragment extends Fragment {

    private TextView mTvTop;
    private TextView mTvBelow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meme, container, false);

        mTvTop = (TextView) view.findViewById(R.id.tvTop);
        mTvBelow = (TextView) view.findViewById(R.id.tvBelow);

        return view;
    }

    public void createMeme(String top, String below) {
        mTvTop.setText(top);
        mTvBelow.setText(below);
    }
}
