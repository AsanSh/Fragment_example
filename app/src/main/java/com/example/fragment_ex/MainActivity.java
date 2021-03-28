package com.example.fragment_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IFragment {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public void hideFragment() {
        TextFragment textFragment = (TextFragment) fragmentManager.findFragmentById(R.id.fragmentText);
        transaction = fragmentManager.beginTransaction();
        if(textFragment!=null){
            transaction.hide(textFragment);
            transaction.commit();}
   }

    @Override
    public void showFragment() {
        ChangeFragment fragment = new ChangeFragment();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frame_layout,fragment);
        transaction.commit();
    }
}