package com.example.user.ramen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class test_fragment extends AppCompatActivity implements fragment_a.FragmentAListener, fragment_b.FragmentBListener{

    private fragment_a fragmentA;
    private fragment_b fragmentB;
    private fragment_manu_promotion manu_promotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);

        fragmentA = new fragment_a();
        fragmentB = new fragment_b();
        manu_promotion = new fragment_manu_promotion();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a, fragmentA)
                .replace(R.id.container_b, fragmentB)
                .replace(R.id.container_c, manu_promotion)
                .commit();

    }

    @Override
    public void onInputASent(CharSequence input){
        fragmentB.updateEditText(input);
    }

    @Override
    public void onInputBSent(CharSequence input){
        fragmentA.updateEditText(input);
    }



}
