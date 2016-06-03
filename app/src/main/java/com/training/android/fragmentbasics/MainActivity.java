package com.training.android.fragmentbasics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements InputFragment.OnCreateMemeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onCreateMeme(String top, String below) {
        MemeFragment fragmentMeme = (MemeFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentMeme);
        fragmentMeme.createMeme(top, below);
    }
}
