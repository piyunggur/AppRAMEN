package com.example.user.ramen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PromotionFragment extends Fragment {
    //private FragmentManuPromotionListener listener;
    private Button next_activity;
    private TextView text;

//    public interface FragmentManuPromotionListenner{
//        void onInputASent(Ch)
//    }

    public PromotionFragment(){
        //Required empty public construtor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_manu_promotion, container, false);

        next_activity = (Button) view.findViewById(R.id.bt_fragment_manu_promotion);
        next_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),LoginActivity.class));
            }
        });

        return view;
    }

}
