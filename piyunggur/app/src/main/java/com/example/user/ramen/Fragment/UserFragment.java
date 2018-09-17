package com.example.user.ramen.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.ramen.Adapter.OrderRecyclerViewAdapter;
import com.example.user.ramen.AlertActivity;
import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

import java.util.ArrayList;

public class UserFragment extends Fragment {
    private OrderFragment fragmentOrder;


    TextView UserName;
    TextView HeadNews;
    TextView NewsAll;
    TextView DataNews1;
    TextView DataNews2;
    Button Menu1;
    Button Menu2;
    Button Menu3;
    Button Menu4;
    Button Menu5;

    Context mContext;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user,container,false);

        mContext = getContext();
        UserName = (TextView) view.findViewById(R.id.user_name);
        HeadNews = (TextView) view.findViewById(R.id.user_head_news);
        NewsAll = (TextView) view.findViewById(R.id.user_news_all);
        DataNews1 = (TextView) view.findViewById(R.id.user_data_news1);
        DataNews2 = (TextView) view.findViewById(R.id.user_data_news2);
        Menu1 = (Button) view.findViewById(R.id.user_menu1);
        Menu2 = (Button) view.findViewById(R.id.user_menu2);
        Menu3 = (Button) view.findViewById(R.id.user_menu3);
        Menu4 = (Button) view.findViewById(R.id.user_menu4);
        Menu5 = (Button) view.findViewById(R.id.user_menu5);


        UserName.setTypeface(CustomFont.getInstance().getFontHead(mContext));
        HeadNews.setTypeface(CustomFont.getInstance().getFontHead(mContext));
        NewsAll.setTypeface(CustomFont.getInstance().getFontData(mContext));
        DataNews1.setTypeface(CustomFont.getInstance().getFontData(mContext));
        DataNews2.setTypeface(CustomFont.getInstance().getFontData(mContext));
        Menu1.setTypeface(CustomFont.getInstance().getFontHead(mContext));
        Menu2.setTypeface(CustomFont.getInstance().getFontHead(mContext));
        Menu3.setTypeface(CustomFont.getInstance().getFontHead(mContext));
        Menu4.setTypeface(CustomFont.getInstance().getFontHead(mContext));
        Menu5.setTypeface(CustomFont.getInstance().getFontHead(mContext));


        DataNews1.setText("ทั้งการสั่งซื้อราเมง สำเร็จ!\nหมายเลขออเดอร 123456");
        DataNews2.setText("ออเดอรหมายเลข 123456 ส่งถึงสถานที่ ที่กำหนดแล้ว\nกรุณายืนยันสิ้นค้าเพื่อส่งมอบเงิน");

        NewsAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(getActivity(), AlertActivity.class));

            }
        });


        return view;
    }



}
