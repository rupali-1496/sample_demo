package com.example.fragmentcommunication;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentOne.FragmentOneListener, FragmentTwo.FragmentTwoListener {
    private FragmentTwo fragmentTwo;
    private FragmentOne fragmentOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_one, fragmentOne)
                .replace(R.id.container_two, fragmentTwo)
                .commit();
    }

    @Override
    public void onInputASent(CharSequence input) {
        fragmentOne.updateEditText(input);
    }

    @Override
    public void onInputBSent(CharSequence input) {
        fragmentTwo.updateEditText(input);
    }
}