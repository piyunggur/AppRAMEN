package com.example.user.ramen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TestFragment extends AppCompatActivity implements fragment_a.FragmentAListener, fragment_b.FragmentBListener{

    private fragment_a fragmentA;
    private fragment_b fragmentB;
    private PromotionFragment manu_promotion;
    private PromotionCardView fCardViewTest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_fragment);

        fragmentA = new fragment_a();
        fragmentB = new fragment_b();
        manu_promotion = new PromotionFragment();
        fCardViewTest = new PromotionCardView();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a, fragmentA)
                .replace(R.id.container_b, fragmentB)
                .replace(R.id.container_c, manu_promotion)
                .replace(R.id.container_d, fCardViewTest)
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
